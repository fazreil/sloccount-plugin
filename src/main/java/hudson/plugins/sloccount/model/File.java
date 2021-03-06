package hudson.plugins.sloccount.model;

import hudson.plugins.sloccount.util.StringUtil;
import java.io.Serializable;

/**
 *
 * @author lordofthepigs
 */
public class File implements Countable, Serializable {
    /** Serial version UID. */
    private static final long serialVersionUID = 0L;

    private String name;
    private final String language;

    /** The module. */
    private final String module;

    private final int lineCount;

    public File(String name, String language, String module, int lineCount){
        this.name = name;
        this.language = language;
        this.module = module;
        this.lineCount = lineCount;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public String getLineCountString() {
        return StringUtil.grouping(getLineCount());
    }
    
    public String getName() {
        return this.name;
    }

    public String getLanguage(){
        return this.language;
    }

    /**
     * Get the module.
     * 
     * @return the module
     */
    public String getModule(){
        return module;
    }

    public void simplifyName(String rootPath){
        this.name = this.name.substring(rootPath.length());
    }
}
