package org.thepatter.convertutil.Service.Impl;

import org.thepatter.convertutil.Service.IXmlCheckerService;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.File;

public class XmlCheckerService implements IXmlCheckerService {

    @Override
    public String xmlChecker(String str) {
        // 创建SAXParser实例
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser =null;
        try{
            saxParser = saxParserFactory.newSAXParser();
        } catch (Exception e){
            System.out.println("xml解析错误");
        }


        // 创建自定义的Handler
        CustomHandler handler = new CustomHandler();

        // 解析XML文件(顺带里面包含了打印xml文件的内容)
        try{
            saxParser.parse(new ByteArrayInputStream(str.getBytes("UTF-8")), handler);
        }catch (Exception e) {
            System.out.println("XML文件格式不正确");
            System.out.println(e);
        }

        System.out.println("xml文件内容为："+handler.getXmlContent());
        return handler.getXmlContent();
    }

    @Override
    public String xmlChecker(File file) {
        // 创建SAXParser实例
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser =null;
        try{
            saxParser = saxParserFactory.newSAXParser();
        } catch (Exception e){
            System.out.println("xml解析错误");
        }


        // 创建自定义的Handler
        CustomHandler handler = new CustomHandler();

        // 解析XML文件(顺带里面包含了打印xml文件的内容)
        try{
            saxParser.parse(file, handler);
        }catch (Exception e) {
            System.out.println("XML文件格式不正确");
            System.out.println(e);
        }

        System.out.println("xml文件内容为："+handler.getXmlContent());
        return handler.getXmlContent();
    }

    private static class CustomHandler extends DefaultHandler {
        private StringBuilder xmlContent = new StringBuilder();
        private String currentElement;

        public String getXmlContent() {
            return xmlContent.toString();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("<"+qName+">");
            for(int i=0;i<attributes.getLength();i++){
                System.out.println(attributes.getQName(i) + ":"
                        + attributes.getValue(i));
            }
            currentElement = qName;
            // 添加开始标记
            xmlContent.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                String attributeName = attributes.getQName(i);
                String attributeValue = attributes.getValue(i);
                xmlContent.append(" ").append(attributeName).append("=\"").append(attributeValue).append("\"");
            }
            xmlContent.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("<"+qName+">");
            currentElement = null;
            // 添加结束标记
            xmlContent.append("</").append(qName).append(">");
            System.out.println("xmlContent:"+xmlContent);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
            String currentContent = new String(ch, start, length);
            if (currentContent.contains(" ") || currentContent.contains("\\n")) {
                System.out.println("包含空格或\\n");
                xmlContent.append("包含空格或\\n");
            } else {
                System.out.println("不包含空格或\\n");
                xmlContent.append(ch, start, length);
            }
        }
    }
}
