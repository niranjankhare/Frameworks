/**
 * 
 */
package appUnderTest.myCustomClasses;

import org.seleniumng.controls.Select;

import com.typesafe.config.Config;

/**
 * @author niru
 *
 */
public class EmberSelect extends Select {

    public EmberSelect(Config config) {
        super(config);
    }

    public void select(CharSequence... keysToSend) {
        System.out.println("This is EmberSelect Select Method");
    }
}
