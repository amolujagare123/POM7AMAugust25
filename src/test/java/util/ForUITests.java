package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ForUITests {


    public static boolean checkAvailability(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isDisplayed();
        }
        catch (Exception e)
        {
            //  actual = false;
        }

        return result;
    }

    public static boolean checkEnability(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isEnabled();
        }
        catch (Exception e)
        {
            //  actual = false;
        }

        return result;
    }

    public static String checkSpellig(WebElement element)
    {
        String result = "";
        try {
            result = element.getText();
        }
        catch (Exception e)
        {
            //  actual = false;
        }

        return result;
    }

    public static String checkPlaceholder(WebElement element)
    {
        String result = "";
        try {
            result = element.getAttribute("placeholder");
        }
        catch (Exception e)
        {
            //  actual = false;
        }

        return result;
    }

    public static String checkStyle(WebElement element,String style)
    {
        String result = "";
        try {
            result = element.getCssValue(style);
        }
        catch (Exception e)
        {
            //  actual = false;
        }

        return result;
    }

    public static String getColorHex(WebElement element,String style)
    {
        String rgbColor = checkStyle(element, style);

       String color =  Color.fromString(rgbColor).asHex();

       return color;
    }
}
