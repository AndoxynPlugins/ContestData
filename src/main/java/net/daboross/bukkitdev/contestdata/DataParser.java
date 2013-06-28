/*
 * Originally Created by Dabo Ross.
 */
package net.daboross.bukkitdev.contestdata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daboross
 */
public class DataParser {

    public String[] parseToList(CData cd) {
        List<String> returnList = new ArrayList<String>();
        for (ContestEntry ce : cd.getEntries()) {
            returnList.add(ce.toString());
        }
        return returnList.toArray(new String[returnList.size()]);
    }
}
