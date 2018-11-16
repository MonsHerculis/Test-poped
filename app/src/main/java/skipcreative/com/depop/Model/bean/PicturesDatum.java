
package skipcreative.com.depop.Model.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PicturesDatum {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("formats")
    @Expose
    private Formats formats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Formats getFormats() {
        return formats;
    }

    public void setFormats(Formats formats) {
        this.formats = formats;
    }

}
