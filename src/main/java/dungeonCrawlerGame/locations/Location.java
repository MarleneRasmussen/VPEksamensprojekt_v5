package dungeonCrawlerGame.locations;

import static dungeonCrawlerGame.locations.Cells.*;

public class Location {

    public static Cells[][] returnLocation(int locationNum) {
        switch (locationNum) {
            case 1: {
                return location1;
            }
            case 2: {
                return location2;
            }
            case 3: {
                return location3;
            }
            case 4: {
                return location4;
            }
            case 5: {
                return location5;
            }
            case 6: {
                return location6;
            }
            case 7: {
                return location7;
            }
            case 8: {
                return location8;
            }
            case 9: {
                return location9;
            }
            case 10: {
                return location10;
            }
            case 11: {
                return location11;
            }
            case 12: {
                return location12;
            }
        }
        return null;
    }

    private static Cells[][] location1 = {
            {II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {W2, W2, B4, B2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2},
            {W1, W1, B3, B1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, II, II, II, GR, GR, II, II, II, II, II, II, II, II, GR, GR, II, II}};

    private static Cells[][] location2 = {
            {II, II, II, II, II, II, II, II, II, II, II, WA, WA, WA, WA, WA, WA, WA},
            {II, GR, GR, GR, GR, II, T0, T0, T0, T0, II, WA, WA, WA, WA, WA, WA, WA},
            {II, GR, GR, GR, GR, II, T0, T0, T0, T0, II, W1, W1, W1, W1, W1, W1, W1},
            {II, GR, GR, GR, GR, II, T0, T0, T0, T0, II, GR, GR, GR, GR, GR, GR, GR},
            {W2, W2, B4, B2, W2, II, T0, T0, T0, T0, II, GR, GR, GR, GR, GR, GR, GR},
            {W1, W1, B3, B1, W1, II, II, GR, GR, II, II, GR, GR, GR, GR, GR, GR, II},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II}};

    private static Cells[][] location3 = {
            {WA, WA, WA, WA, WA, WA, WA, II, II, II, II, II, II, II, II, II, II, II},
            {WA, WA, WA, WA, WA, WA, WA, II, T0, T0, T0, T0, T1, T0, T0, T0, T0, II},
            {W1, W1, W1, W1, W1, W1, W1, II, T0, T0, T0, T1, T0, T0, T0, T0, T0, T0},
            {GR, GR, GR, GR, GR, GR, GR, II, T0, T1, T0, T0, T0, T0, T0, T0, T0, T0},
            {GR, GR, GR, GR, GR, GR, GR, II, T0, T0, T0, T0, T0, T0, T0, T1, T0, II},
            {II, II, II, GR, GR, II, II, I1, II, II, I1, II, II, I1, II, II, I1, II},
            {II, T0, T0, T0, T0, T1, T0, T0, T0, T0, T0, T0, T0, T0, T0, T1, T0, II},
            {II, T0, T1, T0, T0, T0, T0, T0, T0, T1, T0, T0, T0, T0, T0, T0, T0, II},
            {II, T0, T0, T0, T0, T0, T0, T0, T1, T0, T0, T0, T0, T0, T0, T0, T0, II},
            {II, II, II, II, II, II, II, II, II, II, II, II, II, T0, T0, II, II, II}};

    private static Cells[][] location4 = {
            {II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, W2, B4, B2, W2, W2, W2},
            {II, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, W1, B3, B1, W1, W1, W1},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, GR, II},
            {II, II, II, II, II, GR, GR, II, II, II, II, II, II, GR, GR, II, II, II}};

    private static Cells[][] location5 = {
            {II, II, I1, II, T0, T0, II, II, I1, II, II, BS, II, I1, T0, T0, I1, II},
            {II, SA, SA, T5, T0, T1, T6, SA, SA, SA, II, II, II, T0, T0, T0, T0, II},
            {II, SA, SA, T5, T1, T0, T6, SA, SA, SA, SA, II, T0, T0, T0, T0, T1, II},
            {II, SA, SA, T5, T0, T0, T6, SA, SA, SA, SA, II, T0, T0, T0, T0, T0, II},
            {II, SA, SA, T5, T0, T0, T6, SA, SA, SA, SA, II, T0, T1, T0, T0, T0, II},
            {II, SA, SA, T5, T0, T1, T0, T7, T7, T9, SA, II, T0, T0, T0, T0, T0, II},
            {II, SA, SA, T5, T0, T0, T1, T1, T0, T6, SA, II, II, II, T0, T0, II, II},
            {II, SA, SA, T3, T2, T2, T0, T0, T0, T6, SA, II, BS, II, II, II, II, BS},
            {II, SA, SA, SA, SA, SA, T5, T0, T0, T6, SA, II, BS, BS, BS, BS, BS, BS},
            {II, II, II, II, II, II, II, T0, T0, II, II, II, BS, BS, BS, BS, BS, BS}};

    private static Cells[][] location6 = {
            {II, II, II, II, II, II, II, II, II, II, BS, BS, BS, BS, BS, BS, BS, BS},
            {II, SA, SA, SA, SA, SA, SA, T5, T0, II, I1, II, II, I1, II, II, I1, II},
            {II, SA, SA, SA, T8, T7, T7, T1, T0, T0, T0, T0, T0, T1, T0, T0, T0, T0},
            {II, SA, SA, SA, T5, T0, T0, T0, T0, T0, T0, T0, T1, T0, T0, T0, T0, T0},
            {II, SA, SA, SA, T5, T0, LA, LA, LA, II, II, II, I1, II, I1, II, II, II},
            {II, SA, SA, SA, T5, T0, LA, LA, LA, II, T0, T0, T0, T0, T0, T0, T0, T0},
            {II, SA, SA, SA, T5, T0, LA, LA, LA, II, T0, T0, T0, T0, T0, T0, T0, T0},
            {II, SA, SA, T8, T1, T0, LA, LA, LA, II, T0, T0, T0, T0, T0, T0, T0, II},
            {II, SA, SA, T5, T0, T0, LA, LA, LA, II, T0, T0, T0, T0, T0, II, II, II},
            {II, II, II, II, T0, T0, II, II, II, II, II, II, II, T0, T0, II, BS, BS}};

    private static Cells[][] location7 = {
            {II, II, II, II, II, II, II, II, II, II, II, II, II, T0, T0, II, II, II},
            {II, T0, T0, T0, T0, T1, T0, II, T0, T0, T0, T0, T1, T0, T0, T6, SA, II},
            {T0, T1, T0, T0, T0, T0, T0, II, T1, T0, T0, T0, T0, T0, T0, T6, SA, II},
            {T0, T0, T0, T1, T0, T0, T0, II, T0, T0, II, II, II, II, T2, T4, SA, II},
            {II, II, I1, II, II, I1, II, II, T0, T0, II, BS, BS, II, SA, SA, SA, II},
            {T0, T0, T0, T0, T0, T0, T0, T0, T1, T0, II, BS, BS, II, SA, SA, SA, II},
            {T0, T0, T1, T2, T2, T2, T2, T2, T2, T2, II, II, I1, II, SA, SA, SA, II},
            {II, T2, T4, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, II},
            {II, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, II},
            {II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II, II}};

    private static Cells[][] location8 = {
            {BS, II, II, II, II, T0, T0, II, II, II, II, BS, II, T0, T1, II, II, BS},
            {II, I1, LA, LA, LA, T0, T0, LA, LA, LA, I1, II, I1, T0, T0, T0, I1, II},
            {II, LA, LA, T0, T0, T0, T0, T0, T1, LA, LA, II, T0, T0, T1, T0, T0, II},
            {II, LA, T0, T1, T0, T0, T0, T0, T0, T0, LA, II, T1, T0, T0, T0, T0, II},
            {II, LA, T0, T0, T0, T0, T0, T0, T0, T0, LA, II, T0, T0, T0, T1, T0, II},
            {II, LA, T0, T0, T0, T0, T1, T0, T0, T0, LA, II, T0, T0, T0, T0, T0, II},
            {II, LA, T1, T0, T0, T0, T0, T1, T0, T0, LA, II, T0, T1, T0, T0, T0, II},
            {II, LA, LA, T0, T0, T0, T0, T0, T0, LA, LA, II, T0, T0, T0, T0, T0, II},
            {II, II, LA, LA, LA, LA, LA, LA, LA, LA, II, II, II, T0, T0, T1, II, II},
            {BS, II, II, II, II, II, II, II, II, II, II, BS, II, T0, T1, II, II, BS}};

    private static Cells[][] location9 = {
            {II, II, II, II, II, II, II, T0, T0, II, BS, BS, BS, BS, II, II, II, II},
            {II, SA, SA, SA, SA, SA, T5, T0, T0, II, BS, BS, BS, BS, II, T0, T0, T0},
            {II, SA, SA, SA, SA, SA, T5, T0, T0, II, BS, BS, BS, BS, II, T0, T0, T1},
            {II, SA, SA, II, II, SA, T5, T0, T0, II, II, BS, BS, BS, II, T0, T0, II},
            {II, SA, SA, I1, II, SA, T5, T1, T0, T1, II, BS, II, I1, II, T0, T0, II},
            {II, SA, SA, SA, SA, SA, T5, T0, T0, T0, II, I1, II, T0, T0, T0, T0, II},
            {II, SA, SA, SA, SA, SA, T5, T0, T0, T0, T0, T0, T0, T0, T0, T0, T0, II},
            {II, II, II, SA, SA, SA, T3, T2, T2, T2, T2, T2, T2, T2, T2, T2, T2, II},
            {BS, BS, II, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, II, II, II},
            {BS, BS, II, II, II, II, II, II, II, II, II, II, II, II, II, II, BS, BS,}};

    private static Cells[][] location10 = {
            {II, II, II, II, T0, T0, II, II, II, BS, BS, II, II, T0, T0, II, BS, BS},
            {T0, T0, T0, T0, T0, T0, GR, GR, I1, II, II, II, T0, T0, T0, II, BS, BS},
            {T0, T0, T0, T0, T0, T0, GR, GR, GR, GR, II, T0, T0, T0, T0, I1, II, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, II, T0, T0, T0, T0, T0, T0, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, II, T0, T0, T0, T0, T0, T0, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, II, T0, T0, T0, T0, T0, T0, II},
            {II, GR, GR, GR, GR, GR, GR, GR, GR, GR, II, T0, T0, T0, T0, T0, T0, T0},
            {W2, W2, W2, W2, W2, W2, W2, W2, II, II, II, II, II, T0, T0, T0, T0, T0},
            {WA, WA, WA, WA, WA, WA, WA, II, II, BS, BS, BS, II, T0, T0, T0, T0, II},
            {WA, WA, WA, WA, WA, WA, WA, II, BS, BS, BS, BS, II, II, II, II, II, II}};

    private static Cells[][] location11 = {
            {BS, BS, II, II, I1, II, II, II, II, II, BS, II, II, II, II, II, II, II},
            {BS, II, II, T1, T0, T0, T0, T0, T0, II, BS, II, T0, T0, T0, T0, T0, II},
            {II, II, T0, T0, T0, T0, T0, T0, T0, II, II, II, T0, T1, T0, T0, T0, T0},
            {II, T0, T1, T0, T0, T0, II, T0, T1, LA, LA, LA, T0, T0, T0, T0, T0, T0},
            {II, T0, T0, T0, T0, T0, II, T0, T0, LA, LA, LA, T0, T0, T0, T1, T0, II},
            {II, T0, T0, T0, T0, T1, II, T0, T0, II, I1, II, T0, T0, T0, T0, II, II},
            {T0, T0, T0, II, II, I1, II, T0, T0, T0, T0, T0, T1, T0, T0, II, II, BS},
            {T0, T0, T0, II, T0, T1, T0, T0, T0, T0, T0, T1, T0, T0, II, II, BS, BS},
            {II, II, II, II, T0, T0, T0, T1, T0, T0, T0, T0, T0, II, II, BS, BS, BS},
            {BS, BS, BS, II, II, II, II, II, II, II, II, II, II, II, BS, BS, BS, BS}};

    private static Cells[][] location12 = {
            {II, II, II, II, I1, II, II, II, II, II, I1, II, II, T0, T1, II, BS, BS},
            {II, T1, T0, T0, T0, T0, T0, T0, T1, T0, T0, T0, T0, T0, T0, II, II, BS},
            {T0, T0, T0, T1, T0, T0, T0, T0, T0, T0, T0, T0, T0, T0, T0, T0, II, II},
            {T0, T0, T0, T0, T1, T0, T0, II, II, II, II, T0, T0, T1, T0, T0, T0, II},
            {II, T2, T2, T2, T2, T2, T2, II, SA, SA, II, T0, T0, T0, T0, T0, T1, II},
            {II, SA, SA, SA, SA, SA, SA, II, SA, SA, II, T1, T0, T0, T0, T0, T0, II},
            {II, II, SA, SA, SA, SA, SA, II, SA, SA, II, T2, T2, T2, T2, T2, II, II},
            {BS, II, II, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, II, II, BS},
            {BS, BS, II, II, SA, SA, SA, SA, SA, SA, SA, SA, SA, SA, II, II, BS, BS},
            {BS, BS, BS, II, II, II, II, II, II, II, II, II, II, II, II, BS, BS, BS}};

}


