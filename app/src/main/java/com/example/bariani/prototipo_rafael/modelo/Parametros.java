package com.example.bariani.prototipo_rafael.modelo;

import java.io.Serializable;

public class Parametros implements Serializable {
    private float pam1;
    private float pam2;
    private float pam3;

    public float getPam2() {
        return pam2;
    }

    public float getPam3() {
        return pam3;
    }

    public void setPam3(float pam3) {
        this.pam3 = pam3;
    }

    public void setPam2(float pam2) {
        this.pam2 = pam2;
    }

    public float getPam1() {
        return pam1;
    }

    public void setPam1(float pam1) {
        this.pam1 = pam1;
    }
}
