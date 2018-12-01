

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class DrinkTaskBase implements DrinkTask {

    @Override
    public void doTask(String... args) {
        System.out.println("Hello World");
    }
}
