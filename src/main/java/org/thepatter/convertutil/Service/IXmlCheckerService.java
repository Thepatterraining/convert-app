package org.thepatter.convertutil.Service;

import java.io.File;

public interface IXmlCheckerService {

    public String xmlChecker(String str, String chart);

    public String xmlChecker(File file, String chart);

    public Boolean checkRes();
}
