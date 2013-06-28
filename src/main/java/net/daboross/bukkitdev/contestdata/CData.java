package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.playerdata.PData;

/**
 *
 * @author daboross
 */
public class CData {

    private ContestEntry[] contestEntries;
    private PData owner;

    protected CData(ContestEntry[] entries, PData owner) {
        if (owner == null || entries == null) {
            throw new IllegalArgumentException("Null Argument(s) in CData Constructor");
        }
        this.contestEntries = entries;
        this.owner = owner;
    }

    protected void addEntry(ContestEntry entry) {
        if (entry == null) {
            return;
        }
        ContestEntry[] newList = new ContestEntry[contestEntries.length + 1];
        System.arraycopy(contestEntries, 0, newList, 0, contestEntries.length);
    }

    protected ContestEntry[] getEntries() {
        return contestEntries;
    }

    protected PData getOwner() {
        return owner;
    }
}
