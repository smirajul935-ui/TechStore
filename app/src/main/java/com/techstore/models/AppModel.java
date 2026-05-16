package com.techstore.models;
import java.io.Serializable;
import java.util.ArrayList;

public class AppModel implements Serializable {
    public String name, developer, version, size, rating, icon, banner, download, description, category;
    public ArrayList<String> screenshots;

    public AppModel(String n, String d, String v, String s, String r, String i, String b, String dw, String desc, String c, ArrayList<String> ss) {
        name=n; developer=d; version=v; size=s; rating=r; icon=i; banner=b; download=dw; description=desc; category=c; screenshots=ss;
    }
}
