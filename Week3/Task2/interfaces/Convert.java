package Week3.Task2.interfaces;

import Week3.Task2.subclasses.Celsius;
import Week3.Task2.super_class.Degree;

public interface Convert <T extends Degree> {
    T convert (Celsius temperature);
}
