import {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";

const Categories = () => {


    const [categories, setCategories] = useState([]);
    const {idMarketplace} = useParams();


    useEffect(() => {

        axios.get(`http://localhost:8080/markets/${idMarketplace}/categories`)
            .then(response => {
                setCategories(response.data);
            })
            .catch(error => {
                console.error(error);
            })

    }, [idMarketplace]);

    console.log(idMarketplace);

    return (
        <>
            <div className="flex bg-gray-100 py-8 pr-32 pl-32">
                <div className="grid grid-cols-4 gap-8">


                {categories.map(category => (
                <div key={category.name}>
                    {category.name}
                </div>
            ))}
            </div>
            </div>
        </>
    );

}

export default Categories;