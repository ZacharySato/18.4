import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.db.hibernate.HibernateService;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Places;
import ru.fintech.qa.homework.db.hibernate.models.Workman;
import ru.fintech.qa.homework.db.hibernate.models.Zoo;
import ru.fintech.qa.homework.utils.BeforeUtils;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseTests {
    private static List<Animal> animalsTen = new ArrayList<>();

    @BeforeAll
    private static void fillTheBase() {
        BeforeUtils.createData();

        for (int i = 1; i <= 10; i++) {
            Animal iAnimal = new Animal();
            iAnimal.setId(i);
            animalsTen.add(iAnimal);
        }
    }

    @Test
    @DisplayName("В таблице public.animal ровно 10 записей")
    public void testAnimalAmount() {
        Assertions.assertEquals(HibernateService.getAnimals().size(), 10);
    }

    @Test
    @DisplayName("В таблицу public.animal нельзя добавить строку с индексом от 1 до 10 включительно")
    public void testAnimalAddIndex() {
        animalsTen.forEach((animal) -> {
            PersistenceException perex = Assertions.assertThrows(PersistenceException.class, () -> {
                HibernateService.putRecord(animal);
            });
            Throwable conex = perex.getCause();
            Assertions.assertTrue(conex instanceof ConstraintViolationException);
            Assertions.assertTrue(conex.getCause().getMessage().
                    contains("Нарушение уникального индекса"));
        });
    }

    @Test
    @DisplayName("В таблицу public.workman нельзя добавить строку с name = null")
    public void testWorkmanNullName() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Workman nameless = new Workman();
        Set<ConstraintViolation<Workman>> constraintViolations = validator.validate(nameless);
        Assertions.assertEquals(1, constraintViolations.size());
        Assertions.assertEquals("не должно равняться null", constraintViolations.iterator().next().getMessage());
    }


    @Test
    @DisplayName("Если в таблицу public.places добавить еще одну строку, то в ней будет 6 строк")
    public void testPlacesPutAndAmount() {
        Places place = new Places();
        place.setName("Тест");
        HibernateService.putRecord(place);
        Assertions.assertEquals(HibernateService.getPlaces().size(), 6);
    }

    @Test
    @DisplayName("В таблице public.zoo всего три записи с name 'Центральный', 'Северный', 'Западный'")
    public void testZooAmountAndNames() {
        Assertions.assertEquals(HibernateService.getZoos().size(), 3);
        ArrayList<String> legalNames = new ArrayList<>() {
            {
                add("Центральный");
                add("Северный");
                add("Западный");
            }
        };
        List<String> zooNames = HibernateService.getZoos().stream().map(Zoo::getName).collect(Collectors.toList());
        Assertions.assertEquals(legalNames, zooNames);
    }
}