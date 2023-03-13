package org.thepatter.convertutil.Service.Impl;

import cn.hutool.core.map.MapUtil;
import org.thepatter.convertutil.Service.IConvertService;

import java.util.Map;
import java.util.Objects;

public class ConvertService implements IConvertService {

    private Map<Character, Character> strMap;

    public String convertPath;


    public ConvertService() {
        Map<Character, Character> strMap = MapUtil.builder('R', '0')
                .put('J', '1')
                .put('I', '2')
                .put('N', '3')
                .put('G', '4')
                .put('Y', '5')
                .put('O', '6')
                .put('U', '7')
                .put('C', '8')
                .put('A', '9')
                .put('1', 'J')
                .put('2', 'I')
                .put('3', 'N')
                .put('4', 'G')
                .put('5', 'Y')
                .put('6', 'O')
                .put('7', 'U')
                .put('8', 'C')
                .put('9', 'A')
                .put('0', 'R').build();
        this.strMap = strMap;

    }

    @Override
    public String getConvertPath() {
        return convertPath;
    }

    @Override
    public String convert(String str) {
        if (Objects.isNull(str)) {
            return "";
        }

        System.out.println("convert map:{}"+ strMap.toString());
        str = str.toUpperCase();
        System.out.println("convert string param:{}"+ str);
        char[] convertRes = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            Character newStr = strMap.get(s);
            if (Objects.isNull(newStr)) {
                convertRes[i] = s;
            } else {
                convertRes[i] = newStr;
            }
        }
        if (convertRes.length == 0) {
            return "error, convert result is empty";
        }
        return String.valueOf(convertRes);
    }

}