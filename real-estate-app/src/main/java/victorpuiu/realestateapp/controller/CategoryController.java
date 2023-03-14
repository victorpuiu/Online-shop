package victorpuiu.realestateapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.entity.MarketCategory;
import victorpuiu.realestateapp.mapper.MarketCategoryMapper;
import victorpuiu.realestateapp.service.MarketCategoryServiceDefault;

import java.util.List;

@Controller
@RequestMapping("markets/{marketId}/categories")
public class CategoryController {

private final MarketCategoryServiceDefault marketCategoryServiceDefault;


    public CategoryController(MarketCategoryServiceDefault marketCategoryServiceDefault) {
        this.marketCategoryServiceDefault = marketCategoryServiceDefault;
    }



    @GetMapping
    public ResponseEntity<List<MarketCategoryDto>> getAllCategories() {
        List<MarketCategoryDto> categories = marketCategoryServiceDefault.getCategories();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("id")
    public ResponseEntity<MarketCategoryDto> getCategory(@PathVariable long id) {
        MarketCategoryDto category = marketCategoryServiceDefault.findById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<MarketCategoryDto> createCategory(@RequestBody MarketCategoryDto marketCategoryDto){

        MarketCategory category = MarketCategoryMapper.INSTANCE.toMarketCategory(marketCategoryDto);

        MarketCategory savedMarketCategory = marketCategoryServiceDefault.saveCategory(category);
        MarketCategoryDto savedMarketCategoryDto = MarketCategoryMapper.INSTANCE.toMarketCategoryDto(savedMarketCategory);

        return new ResponseEntity<>(savedMarketCategoryDto, HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id ) {
        marketCategoryServiceDefault.deleteById(id);
        return ResponseEntity.noContent().build();

    }




}
