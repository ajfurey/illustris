package com.example.illustris.patient;

public enum Allergy {
    Asthma(false),
    Latex(false),
    MRI_Dye(false),
    Xray_Dye(false);

    private Boolean allergic;

    private Allergy(Boolean allergic) {
        this.allergic = allergic;
    }

    public Boolean isAllergy() {
        return allergic;
    }

    public void setAllergy(Boolean allergic) {
        this.allergic = allergic;
    }
    
}
