package com.workit.test;

import com.workit.test.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFactory {

    public List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Crash Bandicoot 4 : It's About Time (PS4)", 51, "Jeux vidéo", 45));
        products.add(new Product(2, "Godfall Ascended Edition", 109, "Jeux vidéo", 45));
        products.add(new Product(3, "Dirt 5 Limited Edition", 59, "Jeux vidéo", 45));
        products.add(new Product(4, "FIFA 21 Jeu PS4 - Version PS5 incluse", 52, "Jeux vidéo", 20));
        products.add(new Product(5, "Marvel's Avengers Jeu PS4", 53, "Jeux vidéo", 20));
        products.add(new Product(6, "Call of Duty : Black OPS Cold War Jeu PS4", 57, "Jeux vidéo", 20));
        products.add(new Product(7, "The Last of Us Part II Jeu PS4", 54, "Jeux vidéo", 20));
        products.add(new Product(8, "Final Fantasy XV Day One Edition Jeu PS4", 10, "Jeux vidéo", 20));
        products.add(new Product(9, "Les Sims 4", 22, "Jeux vidéo", 32));
        products.add(new Product(10, "Star Wars: Squadrons", 30, "Jeux vidéo", 32));
        products.add(new Product(11, "EA Sports UFC 4", 84, "Jeux vidéo", 32));
        products.add(new Product(12, "Assassin's Creed Odyssey - Jeu PS4", 22, "Jeux vidéo", 12));
        products.add(new Product(13, "Nba 2K21", 45, "Jeux vidéo", 12));
        products.add(new Product(14, "Need For Speed Heat", 26, "Jeux vidéo", 12));
        return products;
    }
}
