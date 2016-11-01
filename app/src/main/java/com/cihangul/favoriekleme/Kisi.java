package com.cihangul.favoriekleme;

/**
 * Created by Cihan on 1.11.2016.
 */

public class Kisi {
  private   String kisIsim;
  private   int kisiResim;
  private   int kisiFavResim;

    public Kisi(String kisIsim, int kisiResim, int kisiFavResim) {
        this.kisIsim = kisIsim;
        this.kisiResim = kisiResim;
        this.kisiFavResim = kisiFavResim;
    }

    public Kisi(){

    }

    public String getKisIsim() {
        return kisIsim;
    }

    public void setKisIsim(String kisIsim) {
        this.kisIsim = kisIsim;
    }

    public int getKisiResim() {
        return kisiResim;
    }

    public void setKisiResim(int kisiResim) {
        this.kisiResim = kisiResim;
    }

    public int getKisiFavResim() {
        return kisiFavResim;
    }

    public void setKisiFavResim(int kisiFavResim) {
        this.kisiFavResim = kisiFavResim;
    }
}
