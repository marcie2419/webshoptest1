package hu.gerviba.webschop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hu.gerviba.webschop.model.CircleEntity;
import hu.gerviba.webschop.model.CircleMemberEntity;
import hu.gerviba.webschop.model.ItemEntity;
import hu.gerviba.webschop.model.OpeningEntity;
import hu.gerviba.webschop.model.ReviewEntity;
import hu.gerviba.webschop.service.CircleMemberService;
import hu.gerviba.webschop.service.CircleService;
import hu.gerviba.webschop.service.ItemService;
import hu.gerviba.webschop.service.OpeningService;
import hu.gerviba.webschop.service.ReviewService;

@Component
@Profile("test")
public class TestingConfig {
    
    @Autowired
    CircleService circles;
    
    @Autowired
    OpeningService openings;
    
    @Autowired
    ItemService items;
    
    @Autowired
    CircleMemberService circleMembers;
    
    @Autowired
    ReviewService reviews;
    
    private static final String LONG_LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n" + 
            "Quisque eu nibh et mi egestas pretium at eget elit. Vestibulum et felis eget dui facilisis tincidunt.\n" + 
            "Maecenas vel nibh aliquam, luctus massa vel, venenatis elit. Integer et finibus eros. Nullam a enim \n" + 
            "luctus, volutpat nisl a, vulputate leo. Nulla facilisi. Praesent in neque eget lectus consequat \n" + 
            "euismod ut eget erat.";
    
    private static final String LONG_LOREM_IPSUM_HOME = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n" + 
            "Quisque eu nibh et mi egestas pretium at eget elit. Vestibulum et felis eget dui facilisis tincidunt.\n" + 
            "Maecenas vel nibh aliquam, luctus massa vel, venenatis elit. Integer et finibus eros. Nullam a enim \n" + 
            "luctus, volutpat nisl a, vulputate leo. Nulla facilisi. Praesent in neque eget lectus consequat \n" + 
            "euismod home page description ut eget erat.";
    
    @PostConstruct
    public void insertDbData() {
        CircleEntity circle;
        
        circles.save(circle = new CircleEntity("Pizz??sch", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "orange", 1991,
                "demo/pizzasch-bg.jpg", "icons/icon-pizzasch.svg", "Szerda"));
        
        openings.save(new OpeningEntity(1525370400000L, 1525392000000L, 1525330800000L, 1525348800000L, 
                "demo/pizzasch-pr.jpg", "Jack pls mit ??rjak ide?", circle, 100, 20));
        
        circleMembers.save(new CircleMemberEntity(circle, "Valami Dezs??", "K??rvez", "demo/profile-pic-1.jpg", 10));
        circleMembers.save(new CircleMemberEntity(circle, "Test Elek", "Tag", "demo/profile-pic-1.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "L??ny N??v", "Gazdas??gis", "demo/profile-pic-2.jpg", 5));
        circleMembers.save(new CircleMemberEntity(circle, "Valami J??nos", "Tag", "demo/profile-pic-1.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "Valami P??ter", "Tag", "demo/profile-pic-1.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "Valami Bogi", "Tag", "demo/profile-pic-2.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "Valami S??ndor", "Tag", "demo/profile-pic-1.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "Valami J??zsef", "Tag", "demo/profile-pic-1.jpg", 0));
        circleMembers.save(new CircleMemberEntity(circle, "Valami Attila", "Tag", "demo/profile-pic-1.jpg", 0));
        
        reviews.save(new ReviewEntity(circle, "Szab?? Gergely", LONG_LOREM_IPSUM, 
                System.currentTimeMillis(), 5, 3, 5, 5));
        reviews.save(new ReviewEntity(circle, "Kredit Husz??r", "Csicskagy??sz ez a k??r", 
                System.currentTimeMillis() - 400000000, 1, 1, 1, 1));
        reviews.save(new ReviewEntity(circle, "Tavasz G??bor", 
                "Tesz sz??veg. Teszt ??rt??kel??s. A kock??zatok ??s a mell??khat??sok pls...",
                System.currentTimeMillis() + 332112300, 4, 5, 4, 4));
        
        items.save(new ItemEntity("??rd??g Pizza", circle, 
                "Jalapeno sz??sz, Pick szal??mi, bacon, pepper??ni, mozzarella, lorem ipsum dolor sit amet", 
                "Jalapeno sz??sz, Pick szal??mi, bacon, pepper??ni, mozzarella", 
                "pizza csipos jalapeno pick bacon pepperoni mozzarella",
                "[{\"name\":\"size\",\"values\":[\"32\",\"42\",\"64\"]}]", 800, true, "cdn/items/1.jpg"));
        
        items.save(new ItemEntity("Songoku Pizza", circle, 
                "Paradicsomos alap, sonka, kukorica, friss gomba, mozzarella, lorem ipsum dolor sit amet",
                "Paradicsomos alap, sonka, kukorica, friss gomba, mozzarella", 
                "pizza paradicsom sonka kukorica asd song",
                "[{\"name\":\"size\"}]", 800, true, "cdn/items/2.jpg"));
        
        items.save(new ItemEntity("Royal w/ Cheese Pizza", circle, 
                "Bacon, sonka, paradicsom, mozzarella, sajtkr??mes alap, lorem ipsum dolor sit amet", 
                "Bacon, sonka, paradicsom, mozzarella, sajtkr??mes alap", 
                "pizza bacon sonka paradicsom mozzarella sajt krem",
                "[{\"name\":\"size\"}]", 800, true, "cdn/items/3.jpg"));
        
        circles.save(circle = new CircleEntity("Dzs??jrosz", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "green", 1995,
                "demo/dzsajrosz-bg.jpg", "icons/icon-dzsajrosz.svg", "Cs??t??rt??k"));

        items.save(new ItemEntity("Dzs??jrosz pit??ban", circle, 
                "Pita, hagyma, sal??ta, paradicsom, sz??sz, lorem ipsum dolor sit amet", 
                "Pita, hagyma, sal??ta, paradicsom, sz??sz", 
                "gyros pita hagyma",
                "[{\"name\":\"size\",\"values\":[\"kicsi\",\"nagy\"]}]", 800, true, "cdn/items/5.jpg"));
        
        openings.save(new OpeningEntity(1525467600000L, 1525478400000L, 1525417200000L, 1525435200000L, 
                "demo/dzsajrosz-pr.jpg", "Type your feeling here", circle, 100, 20));
        
        circles.save(circle = new CircleEntity("Americano", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "blue",  2002,
                "demo/americano-bg.jpg", "icons/icon-americano.svg", "Kedd"));

        items.save(new ItemEntity("Random Burger", circle, 
                "Iz??, hoz??, bigy?? ??s return 4, lorem ipsum dolor sit amet", 
                "Iz??, hoz??, bigy?? ??s return 4", 
                "burger asd",
                "[{\"name\":\"size\"}]", 600, true, "cdn/items/4.jpg"));
        
        openings.save(new OpeningEntity(1525284000000L, 1525305600000L, 1525244400000L, 1525262400000L, 
                "demo/americano-pr.jpg", "Random moment cuccok", circle, 100, 20));
        
        circles.save(circle = new CircleEntity("V??d??r", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "purple",  2005,
                "demo/vodor-bg.jpg", "icons/icon-vodor.svg", "H??tf??"));
        
        items.save(new ItemEntity("S??ltkrumpli", circle, 
                "Iz??, hoz??, bigy?? ??s 4, lorem ipsum dolor sit amet", 
                "Iz??, hoz??, bigy?? ??s 4", 
                "sult krumpli",
                "[{\"name\":\"size\"}]", 600, true, "cdn/items/8.jpg"));
        
        openings.save(new OpeningEntity(1525197600000L, 1525219200000L, 1525158000000L, 1525176000000L, 
                "demo/dzsajrosz-pr.jpg", "Feeling t??pus?? nyit??s", circle, 100, 20));
        
        circles.save(circle = new CircleEntity("Kakas", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "red", 1999,
                "demo/kakas-bg.jpg", "icons/icon-kakas.svg", "Vas??rnap"));
        
        openings.save(new OpeningEntity(1525726800000L, 152573760021000L, 1525726800000L, 1525737600000L, 
                "demo/kakas-pr.jpg", "Forradalmi nyit??s", circle, 100, 20));

        items.save(new ItemEntity("Sonk??s melegszendvics", circle, 
                "Sonka, sajt, hagyma, vaj, lorem ipsum dolor sit amet", 
                "Sonka, sajt, hagyma, vaj", 
                "meleg szendvics sonka sajt hagyma",
                "[{\"name\":\"size\"}]", 200, true, "cdn/items/6.jpg"));
        
        circles.save(circle = new CircleEntity("L??ngosch", LONG_LOREM_IPSUM, LONG_LOREM_IPSUM_HOME, "yellow",  1994,
                "demo/langosch-bg.jpg", "icons/icon-langosch.svg", "Vas??rnap (2 hetente)"));
        
        openings.save(new OpeningEntity(1525716000000L, 1525737600000L, 1525676400000L, 1525694400000L, 
                "demo/langosch-pr.jpg", "T??zes l??ngos", circle, 100, 20));

        items.save(new ItemEntity("T??zes l??ngos", circle, 
                "Chili, sonka, paradicsom, mozzarella, sajtkr??mes alap, lorem ipsum dolor sit amet", 
                "Chili, sonka, paradicsom, mozzarella, sajtkr??mes alap", 
                "langsch langs tuzes chili",
                "[{\"name\":\"size\"}]", 500, true, "cdn/items/7.jpg"));
        
    }
    
}
