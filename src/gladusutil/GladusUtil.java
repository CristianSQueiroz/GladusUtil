/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladusutil;

import gladusutil.Components.HashMap;

/**
 *
 * @author csqueiroz
 */
public class GladusUtil {

    public static Float getFloat(Object o1) {
        try {
            return Float.valueOf(o1.toString());
        } catch (Exception e) {
            return 0F;
        }
    }

    public static Integer getInteger(Object o1) {
        try {
            return Integer.valueOf(o1.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static Double getDouble(Object o1) {
        try {
            return Double.valueOf(o1.toString());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static boolean containsIgnoraCase(String s1, String s2) {
        return s1.toUpperCase().contains(s2.toUpperCase());
    }

    public static int indexOfIgnoreCase(String s1, String s2) {
        return s1.toUpperCase().indexOf(s2.toUpperCase());
    }

    public static HashMap getValueNumeric(int inicialPos, String comand, boolean isForward) {
        boolean valueFounded = false;
        HashMap hashMap = new HashMap();
        int pos = inicialPos;
        int inicialPosValue = 0;
        int finalPosValue = 0;
        while (!valueFounded) {
            if (isAValueNumeric(pos, comand)) {
                valueFounded = true;
                inicialPosValue = pos;
            } else {
                if (isForward) {
                    pos++;
                } else {
                    pos--;
                }
            }
        }

        while (valueFounded) {
            if (pos < comand.length() - 1 && pos > 0) {
                if (isAValueNumeric(pos, comand)) {
                    if (isForward) {
                        pos++;
                    } else {
                        pos--;
                    }
                } else {
                    valueFounded = false;
                    finalPosValue = pos;
                }
            } else {
                valueFounded = false;
                finalPosValue = pos;
            }

        }
        if (inicialPosValue == finalPosValue) {
            hashMap.put("VALUE", String.valueOf(comand.charAt(inicialPosValue)));
        } else {
            if (isForward) {
                hashMap.put("VALUE", comand.substring(inicialPosValue, finalPosValue + 1));
            } else {
                hashMap.put("VALUE", comand.substring(finalPosValue, inicialPosValue + 1));
            }
        }

        hashMap.put("LAST_POS", pos < comand.length() - 1 ? pos : comand.length() - 1);
        hashMap.put("INICIAL_POS", pos);
        return hashMap;

    }

    public static HashMap getValueNumeric(int inicialPos, String comand) {
        return getValueNumeric(inicialPos, comand, true);

    }

    private static boolean isAValueNumeric(int pos, String comand) {
        String character = String.valueOf(comand.charAt(pos));
        if (character.equalsIgnoreCase(".")) {
            return true;
        }
        return isNumeric(character);
    }

    private static boolean isNumeric(String character) {
        try {
            Integer.valueOf(character);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
