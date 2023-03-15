package victorpuiu.realestateapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public MarketCategoryDto saveOrEdit(MarketCategoryDto marketCategoryDto) {
        return marketCategoryRepository.findById(marketCategoryDto.getId() == null ? 0 : marketCategoryDto.getId())
                .map((marketCategory) -> edit(marketCategory, marketCategoryDto))
                .orElseGet(() -> save(marketCategoryDto));
    }

    @Transactional
    public MarketCategoryDto edit(MarketCategory marketCategory, MarketCategoryDto marketCategoryDto){
        MarketCategory toEdit = MarketCategoryMapper.INSTANCE.toMarketCategory(marketCategoryDto);
        toEdit.setId(marketCategory.getId());

        return MarketCategoryMapper.INSTANCE.toMarketCategoryDto(marketCategoryRepository.save(toEdit));
    }

    @Transactional
    public MarketCategoryDto save(MarketCategoryDto marketCategoryDto) {
        return MarketCategoryMapper.INSTANCE
                .toMarketCategoryDto(marketCategoryRepository
                        .save(MarketCategoryMapper.INSTANCE.toMarketCategory(marketCategoryDto)));
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














