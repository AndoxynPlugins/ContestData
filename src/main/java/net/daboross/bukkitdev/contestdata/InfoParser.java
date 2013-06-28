package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.playerdata.Data;
import net.daboross.bukkitdev.playerdata.DataDisplayParser;

/**
 *
 * @author daboross
 */
public class InfoParser implements DataDisplayParser {

    private static InfoParser instance;
    private static final Object INSTANCE_LOCK = new Object();

    private InfoParser() {
    }

    public static InfoParser getInstance() {
        synchronized (INSTANCE_LOCK) {
            if (instance == null) {
                instance = new InfoParser();
            }
        }
        return instance;
    }

    public String[] shortInfo(Data d) {
        return new String[0];
    }

    public String[] longInfo(Data d) {
        return new String[0];
    }
}
