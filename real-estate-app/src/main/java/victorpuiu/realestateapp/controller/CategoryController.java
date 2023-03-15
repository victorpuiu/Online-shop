package victorpuiu.realestateapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.service.MarketCategoryService;
import victorpuiu.realestateapp.service.MarketCategoryServiceDefault;

import java.util.List;

@Controller
@RequestMapping("markets/{marketId}/categories")
public class CategoryController {

private final MarketCategoryService marketCategoryService;


    public CategoryController(MarketCategoryServiceDefault marketCategoryService) {
        this.marketCategoryService = marketCategoryService;
    }



    @GetMapping
    public ResponseEntity<List<MarketCategoryDto>> getAllCategories( ) {
        List<MarketCategoryDto> categories = marketCategoryService.getCategories();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("id")
    public ResponseEntity<MarketCategoryDto> getCategory(@PathVariable long id) {
        MarketCategoryDto category = marketCategoryService.findById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<MarketCategoryDto> createCategory(@RequestBody MarketCategoryDto marketCategoryDto){

//        MarketCategory category = MarketCategoryMapper.INSTANCE.toMarketCategory(marketCategoryDto);

        MarketCategoryDto savedMarketCategoryDto = marketCategoryService.saveOrEdit(marketCategoryDto);
//        MarketCategoryDto savedMarketCategoryDto = MarketCategoryMapper.INSTANCE.toMarketCategoryDto(savedMarketCategory);

        return new ResponseEntity<>(savedMarketCategoryDto, HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id ) {
        marketCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }




}
