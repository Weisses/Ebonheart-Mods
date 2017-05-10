package com.viesis.viescraft.api;

import java.awt.Color;
import java.util.ArrayList;

import net.minecraft.client.resources.I18n;

public class ColorHelperVC {
	
	/** Initialize the color list that we have. */
    public static ArrayList<ColorName> initColorList() 
    {
        ArrayList<ColorName> colorList = new ArrayList<ColorName>();
        colorList.add(new ColorName(I18n.format("vc.item.color.1"), 0xF0, 0xF8, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.2"), 0xFA, 0xEB, 0xD7));
        colorList.add(new ColorName(I18n.format("vc.item.color.3"), 0x00, 0xFF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.4"), 0x7F, 0xFF, 0xD4));
        colorList.add(new ColorName(I18n.format("vc.item.color.5"), 0xF0, 0xFF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.6"), 0xF5, 0xF5, 0xDC));
        colorList.add(new ColorName(I18n.format("vc.item.color.7"), 0xFF, 0xE4, 0xC4));
        colorList.add(new ColorName(I18n.format("vc.item.color.8"), 0x00, 0x00, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.9"), 0xFF, 0xEB, 0xCD));
        colorList.add(new ColorName(I18n.format("vc.item.color.10"), 0x00, 0x00, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.11"), 0x8A, 0x2B, 0xE2));
        colorList.add(new ColorName(I18n.format("vc.item.color.12"), 0xA5, 0x2A, 0x2A));
        colorList.add(new ColorName(I18n.format("vc.item.color.13"), 0xDE, 0xB8, 0x87));
        colorList.add(new ColorName(I18n.format("vc.item.color.14"), 0x5F, 0x9E, 0xA0));
        colorList.add(new ColorName(I18n.format("vc.item.color.15"), 0x7F, 0xFF, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.16"), 0xD2, 0x69, 0x1E));
        colorList.add(new ColorName(I18n.format("vc.item.color.17"), 0xFF, 0x7F, 0x50));
        colorList.add(new ColorName(I18n.format("vc.item.color.18"), 0x64, 0x95, 0xED));
        colorList.add(new ColorName(I18n.format("vc.item.color.19"), 0xFF, 0xF8, 0xDC));
        colorList.add(new ColorName(I18n.format("vc.item.color.20"), 0xDC, 0x14, 0x3C));
        colorList.add(new ColorName(I18n.format("vc.item.color.21"), 0x00, 0xFF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.22"), 0x00, 0x00, 0x8B));
        colorList.add(new ColorName(I18n.format("vc.item.color.23"), 0x00, 0x8B, 0x8B));
        colorList.add(new ColorName(I18n.format("vc.item.color.24"), 0xB8, 0x86, 0x0B));
        colorList.add(new ColorName(I18n.format("vc.item.color.25"), 0xA9, 0xA9, 0xA9));
        colorList.add(new ColorName(I18n.format("vc.item.color.26"), 0x00, 0x64, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.27"), 0xBD, 0xB7, 0x6B));
        colorList.add(new ColorName(I18n.format("vc.item.color.28"), 0x8B, 0x00, 0x8B));
        colorList.add(new ColorName(I18n.format("vc.item.color.29"), 0x55, 0x6B, 0x2F));
        colorList.add(new ColorName(I18n.format("vc.item.color.30"), 0xFF, 0x8C, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.31"), 0x99, 0x32, 0xCC));
        colorList.add(new ColorName(I18n.format("vc.item.color.32"), 0x8B, 0x00, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.33"), 0xE9, 0x96, 0x7A));
        colorList.add(new ColorName(I18n.format("vc.item.color.34"), 0x8F, 0xBC, 0x8F));
        colorList.add(new ColorName(I18n.format("vc.item.color.35"), 0x48, 0x3D, 0x8B));
        colorList.add(new ColorName(I18n.format("vc.item.color.36"), 0x2F, 0x4F, 0x4F));
        colorList.add(new ColorName(I18n.format("vc.item.color.37"), 0x00, 0xCE, 0xD1));
        colorList.add(new ColorName(I18n.format("vc.item.color.38"), 0x94, 0x00, 0xD3));
        colorList.add(new ColorName(I18n.format("vc.item.color.39"), 0xFF, 0x14, 0x93));
        colorList.add(new ColorName(I18n.format("vc.item.color.40"), 0x00, 0xBF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.41"), 0x69, 0x69, 0x69));
        colorList.add(new ColorName(I18n.format("vc.item.color.42"), 0x1E, 0x90, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.43"), 0xB2, 0x22, 0x22));
        colorList.add(new ColorName(I18n.format("vc.item.color.44"), 0xFF, 0xFA, 0xF0));
        colorList.add(new ColorName(I18n.format("vc.item.color.45"), 0x22, 0x8B, 0x22));
        colorList.add(new ColorName(I18n.format("vc.item.color.46"), 0xFF, 0x00, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.47"), 0xDC, 0xDC, 0xDC));
        colorList.add(new ColorName(I18n.format("vc.item.color.48"), 0xF8, 0xF8, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.49"), 0xFF, 0xD7, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.50"), 0xDA, 0xA5, 0x20));
        colorList.add(new ColorName(I18n.format("vc.item.color.51"), 0x80, 0x80, 0x80));
        colorList.add(new ColorName(I18n.format("vc.item.color.52"), 0x00, 0x80, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.53"), 0xAD, 0xFF, 0x2F));
        colorList.add(new ColorName(I18n.format("vc.item.color.54"), 0xF0, 0xFF, 0xF0));
        colorList.add(new ColorName(I18n.format("vc.item.color.55"), 0xFF, 0x69, 0xB4));
        colorList.add(new ColorName(I18n.format("vc.item.color.56"), 0xCD, 0x5C, 0x5C));
        colorList.add(new ColorName(I18n.format("vc.item.color.57"), 0x4B, 0x00, 0x82));
        colorList.add(new ColorName(I18n.format("vc.item.color.58"), 0xFF, 0xFF, 0xF0));
        colorList.add(new ColorName(I18n.format("vc.item.color.59"), 0xF0, 0xE6, 0x8C));
        colorList.add(new ColorName(I18n.format("vc.item.color.60"), 0xE6, 0xE6, 0xFA));
        colorList.add(new ColorName(I18n.format("vc.item.color.61"), 0xFF, 0xF0, 0xF5));
        colorList.add(new ColorName(I18n.format("vc.item.color.62"), 0x7C, 0xFC, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.63"), 0xFF, 0xFA, 0xCD));
        colorList.add(new ColorName(I18n.format("vc.item.color.64"), 0xAD, 0xD8, 0xE6));
        colorList.add(new ColorName(I18n.format("vc.item.color.65"), 0xF0, 0x80, 0x80));
        colorList.add(new ColorName(I18n.format("vc.item.color.66"), 0xE0, 0xFF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.67"), 0xFA, 0xFA, 0xD2));
        colorList.add(new ColorName(I18n.format("vc.item.color.68"), 0xD3, 0xD3, 0xD3));
        colorList.add(new ColorName(I18n.format("vc.item.color.69"), 0x90, 0xEE, 0x90));
        colorList.add(new ColorName(I18n.format("vc.item.color.70"), 0xFF, 0xB6, 0xC1));
        colorList.add(new ColorName(I18n.format("vc.item.color.71"), 0xFF, 0xA0, 0x7A));
        colorList.add(new ColorName(I18n.format("vc.item.color.72"), 0x20, 0xB2, 0xAA));
        colorList.add(new ColorName(I18n.format("vc.item.color.73"), 0x87, 0xCE, 0xFA));
        colorList.add(new ColorName(I18n.format("vc.item.color.74"), 0x77, 0x88, 0x99));
        colorList.add(new ColorName(I18n.format("vc.item.color.75"), 0xB0, 0xC4, 0xDE));
        colorList.add(new ColorName(I18n.format("vc.item.color.76"), 0xFF, 0xFF, 0xE0));
        colorList.add(new ColorName(I18n.format("vc.item.color.77"), 0x00, 0xFF, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.78"), 0x32, 0xCD, 0x32));
        colorList.add(new ColorName(I18n.format("vc.item.color.79"), 0xFA, 0xF0, 0xE6));
        colorList.add(new ColorName(I18n.format("vc.item.color.80"), 0xFF, 0x00, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.81"), 0x80, 0x00, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.82"), 0x66, 0xCD, 0xAA));
        colorList.add(new ColorName(I18n.format("vc.item.color.83"), 0x00, 0x00, 0xCD));
        colorList.add(new ColorName(I18n.format("vc.item.color.84"), 0xBA, 0x55, 0xD3));
        colorList.add(new ColorName(I18n.format("vc.item.color.85"), 0x93, 0x70, 0xDB));
        colorList.add(new ColorName(I18n.format("vc.item.color.86"), 0x3C, 0xB3, 0x71));
        colorList.add(new ColorName(I18n.format("vc.item.color.87"), 0x7B, 0x68, 0xEE));
        colorList.add(new ColorName(I18n.format("vc.item.color.88"), 0x00, 0xFA, 0x9A));
        colorList.add(new ColorName(I18n.format("vc.item.color.89"), 0x48, 0xD1, 0xCC));
        colorList.add(new ColorName(I18n.format("vc.item.color.90"), 0xC7, 0x15, 0x85));
        colorList.add(new ColorName(I18n.format("vc.item.color.91"), 0x19, 0x19, 0x70));
        colorList.add(new ColorName(I18n.format("vc.item.color.92"), 0xF5, 0xFF, 0xFA));
        colorList.add(new ColorName(I18n.format("vc.item.color.93"), 0xFF, 0xE4, 0xE1));
        colorList.add(new ColorName(I18n.format("vc.item.color.94"), 0xFF, 0xE4, 0xB5));
        colorList.add(new ColorName(I18n.format("vc.item.color.95"), 0xFF, 0xDE, 0xAD));
        colorList.add(new ColorName(I18n.format("vc.item.color.96"), 0x00, 0x00, 0x80));
        colorList.add(new ColorName(I18n.format("vc.item.color.97"), 0xFD, 0xF5, 0xE6));
        colorList.add(new ColorName(I18n.format("vc.item.color.98"), 0x80, 0x80, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.99"), 0x6B, 0x8E, 0x23));
        colorList.add(new ColorName(I18n.format("vc.item.color.100"), 0xFF, 0xA5, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.101"), 0xFF, 0x45, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.102"), 0xDA, 0x70, 0xD6));
        colorList.add(new ColorName(I18n.format("vc.item.color.103"), 0xEE, 0xE8, 0xAA));
        colorList.add(new ColorName(I18n.format("vc.item.color.104"), 0x98, 0xFB, 0x98));
        colorList.add(new ColorName(I18n.format("vc.item.color.105"), 0xAF, 0xEE, 0xEE));
        colorList.add(new ColorName(I18n.format("vc.item.color.106"), 0xDB, 0x70, 0x93));
        colorList.add(new ColorName(I18n.format("vc.item.color.107"), 0xFF, 0xEF, 0xD5));
        colorList.add(new ColorName(I18n.format("vc.item.color.108"), 0xFF, 0xDA, 0xB9));
        colorList.add(new ColorName(I18n.format("vc.item.color.109"), 0xCD, 0x85, 0x3F));
        colorList.add(new ColorName(I18n.format("vc.item.color.110"), 0xFF, 0xC0, 0xCB));
        colorList.add(new ColorName(I18n.format("vc.item.color.111"), 0xDD, 0xA0, 0xDD));
        colorList.add(new ColorName(I18n.format("vc.item.color.112"), 0xB0, 0xE0, 0xE6));
        colorList.add(new ColorName(I18n.format("vc.item.color.113"), 0x80, 0x00, 0x80));
        colorList.add(new ColorName(I18n.format("vc.item.color.114"), 0xFF, 0x00, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.115"), 0xBC, 0x8F, 0x8F));
        colorList.add(new ColorName(I18n.format("vc.item.color.116"), 0x41, 0x69, 0xE1));
        colorList.add(new ColorName(I18n.format("vc.item.color.117"), 0x8B, 0x45, 0x13));
        colorList.add(new ColorName(I18n.format("vc.item.color.118"), 0xFA, 0x80, 0x72));
        colorList.add(new ColorName(I18n.format("vc.item.color.119"), 0xF4, 0xA4, 0x60));
        colorList.add(new ColorName(I18n.format("vc.item.color.120"), 0x2E, 0x8B, 0x57));
        colorList.add(new ColorName(I18n.format("vc.item.color.121"), 0xFF, 0xF5, 0xEE));
        colorList.add(new ColorName(I18n.format("vc.item.color.122"), 0xA0, 0x52, 0x2D));
        colorList.add(new ColorName(I18n.format("vc.item.color.123"), 0xC0, 0xC0, 0xC0));
        colorList.add(new ColorName(I18n.format("vc.item.color.124"), 0x87, 0xCE, 0xEB));
        colorList.add(new ColorName(I18n.format("vc.item.color.125"), 0x6A, 0x5A, 0xCD));
        colorList.add(new ColorName(I18n.format("vc.item.color.126"), 0x70, 0x80, 0x90));
        colorList.add(new ColorName(I18n.format("vc.item.color.127"), 0xFF, 0xFA, 0xFA));
        colorList.add(new ColorName(I18n.format("vc.item.color.128"), 0x00, 0xFF, 0x7F));
        colorList.add(new ColorName(I18n.format("vc.item.color.129"), 0x46, 0x82, 0xB4));
        colorList.add(new ColorName(I18n.format("vc.item.color.130"), 0xD2, 0xB4, 0x8C));
        colorList.add(new ColorName(I18n.format("vc.item.color.131"), 0x00, 0x80, 0x80));
        colorList.add(new ColorName(I18n.format("vc.item.color.132"), 0xD8, 0xBF, 0xD8));
        colorList.add(new ColorName(I18n.format("vc.item.color.133"), 0xFF, 0x63, 0x47));
        colorList.add(new ColorName(I18n.format("vc.item.color.134"), 0x40, 0xE0, 0xD0));
        colorList.add(new ColorName(I18n.format("vc.item.color.135"), 0xEE, 0x82, 0xEE));
        colorList.add(new ColorName(I18n.format("vc.item.color.136"), 0xF5, 0xDE, 0xB3));
        colorList.add(new ColorName(I18n.format("vc.item.color.137"), 0xFF, 0xFF, 0xFF));
        colorList.add(new ColorName(I18n.format("vc.item.color.138"), 0xF5, 0xF5, 0xF5));
        colorList.add(new ColorName(I18n.format("vc.item.color.139"), 0xFF, 0xFF, 0x00));
        colorList.add(new ColorName(I18n.format("vc.item.color.140"), 0x9A, 0xCD, 0x32));
        return colorList;
    }
    
    /** Get the closest color name from our list. */
    public static String getColorNameFromRgb(float r, float g, float b) 
    {
        ArrayList<ColorName> colorList = initColorList();
        ColorName closestMatch = null;
        int minMSE = Integer.MAX_VALUE;
        int mse;
        for (ColorName c : colorList) 
        {
            mse = c.computeMSE(r, g, b);
            if (mse < minMSE) 
            {
                minMSE = mse;
                closestMatch = c;
            }
        }
        
        if (closestMatch != null) 
        {
            return closestMatch.getName();
        } 
        else 
        {
            return "No matched color name.";
        }
    }
    
    /** Convert hexColor to rgb, then call getColorNameFromRgb(r, g, b). */
    public String getColorNameFromHex(int hexColor) 
    {
        int r = (hexColor & 0xFF0000) >> 16;
        int g = (hexColor & 0xFF00) >> 8;
        int b = (hexColor & 0xFF);
        return getColorNameFromRgb(r, g, b);
    }
    
    public int colorToHex(Color c) 
    {
        return Integer.decode("0x" + Integer.toHexString(c.getRGB()).substring(2));
    }
    
    public String getColorNameFromColor(Color color) 
    {
        return getColorNameFromRgb(color.getRed(), color.getGreen(), color.getBlue());
    }
    
    /** SubClass of ColorUtils. In order to lookup color name. */
    public static class ColorName 
    {
        public int r, g, b;
        public String name;
        
        public ColorName(String name, int r, int g, int b) 
        {
            this.r = r;
            this.g = g;
            this.b = b;
            this.name = name;
        }
        
        public int computeMSE(float r2, float g2, float b2) 
        {
            return (int) (((r2 - r) * (r2 - r) + (g2 - g) * (g2 - g) + (b2 - b) * (b2 - b)) / 3);
        }
        
        public int getR() 
        {
            return r;
        }
        
        public int getG() 
        {
            return g;
        }
        
        public int getB() 
        {
            return b;
        }
        
        public String getName() 
        {
            return name;
        }
    }
}
