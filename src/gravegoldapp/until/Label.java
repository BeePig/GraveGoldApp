/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravegoldapp.until;

import gravegoldapp.model.Environment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * define label of node in {@link Environment}
 *
 * @author beepi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.CONSTRUCTOR,ElementType.FIELD})
public @interface Label {

    enum LABEL {

        WUMPUS,
        PIT,
        GOLD,
        NEAR_WUMPUS,
        NEAR_PIT,
        WUMPUS_PIT,
        NEAR_WUMPUS_PIT,
        NULL
    }

    LABEL label() default LABEL.NULL;
}
