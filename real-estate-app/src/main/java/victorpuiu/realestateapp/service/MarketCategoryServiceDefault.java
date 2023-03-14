package victorpuiu.realestateapp.service;

import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.entity.MarketCategory;
import victorpuiu.realestateapp.mapper.MarketCategoryMapper;
import victorpuiu.realestateapp.repository.MarketCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketCategoryServiceDefault implements MarketCategoryService{
    private final MarketCategoryRepository marketCategoryRepository;

    public MarketCategoryServiceDefault(MarketCategoryRepository marketCategoryRepository) {
        this.marketCategoryRepository = marketCategoryRepository;
    }

    @Override
    public List<MarketCategoryDto> getCategories() {
        List<MarketCategory> marketCategory = marketCategoryRepository.findAll();
        return marketCategory.stream().map(MarketCategoryMapper.INSTANCE::toMarketCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public MarketCategoryDto findById(long id) {
        Optional<MarketCategory> marketCategory = marketCategoryRepository.findById(id);
        if (!marketCategory.isPresent()) {
            throw new IllegalArgumentException("Market category does not exist");
        }
        return marketCategory.map(MarketCategoryMapper.INSTANCE::toMarketCategoryDto)
                .orElseThrow(() -> new IllegalArgumentException("Market Category does not exist"));
    }

    public MarketCategory saveCategory(MarketCategory marketCategory) {
        return marketCategoryRepository.save(marketCategory);
    }

    @Override
    public void deleteById(long id) {

        Optional<MarketCategory> categoryOptional = marketCategoryRepository.findById(id);
        if (!categoryOptional.isPresent()){
            throw new IllegalArgumentException("Market category does not exist");
        }

        MarketCategory category = categoryOptional.get();
        marketCategoryRepository.delete(category);




    }
}














