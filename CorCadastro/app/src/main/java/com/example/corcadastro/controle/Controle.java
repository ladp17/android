package com.example.corcadastro.controle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Controle {

    public static String toHexa(Integer value) {

        String hexa = "";
        Integer resto;

        do {
            resto = value % 16;
            value = value / 16;

            hexa = resto + hexa;

        } while (value != 0);

        return hexa;

    }

    public static Intent chamaActivity(Activity context, Class next, Bundle bundle) {

        Intent it = new Intent(context, next);

        it.putExtras(bundle);

        return it;

    }

    public static String calculaCor(Integer R, Integer G, Integer B) {

        String hex;

        hex = "#" + R + G + B;

        return hex;

    }

}
