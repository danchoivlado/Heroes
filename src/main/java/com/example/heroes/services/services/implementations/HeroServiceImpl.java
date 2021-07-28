package com.example.heroes.services.services.implementations;

import com.example.heroes.data.models.Hero;
import com.example.heroes.data.models.Item;
import com.example.heroes.data.models.enums.Slot;
import com.example.heroes.data.repositories.HeroRepository;
import com.example.heroes.services.models.heroes.HeroDetailsServiceModel;
import com.example.heroes.services.models.heroes.HeroItemServiceModel;
import com.example.heroes.services.services.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private HeroRepository heroRepository;
    private ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper){

        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HeroDetailsServiceModel getDetailsAboutHero(String username) {
        if (!this.heroRepository.existsHeroByUsername(username))
        {
            return null;
        }

        Hero hero = heroRepository.findHeroByUsername(username);
        HeroDetailsServiceModel detailsModel = modelMapper.map(hero, HeroDetailsServiceModel.class);

        detailsModel.setHelmet(this.getItemFromInventory(hero.getInventory(),Slot.HELMET));
        detailsModel.setPads(this.getItemFromInventory(hero.getInventory(),Slot.PADS));
        detailsModel.setGauntlets(this.getItemFromInventory(hero.getInventory(),Slot.GAUNTLETS));
        detailsModel.setPauldron(this.getItemFromInventory(hero.getInventory(),Slot.PAULDRON));
        detailsModel.setWeapon(this.getItemFromInventory(hero.getInventory(),Slot.WEAPON));

        return detailsModel;
    }

    private HeroItemServiceModel getItemFromInventory(List<Item> heroInventory, Slot slot){

        for (Item item : heroInventory){
            if (item.getSlot().getCode() == slot.getCode()){
                return modelMapper.map(item, HeroItemServiceModel.class);
            }
        }

        return null;
    }
}
