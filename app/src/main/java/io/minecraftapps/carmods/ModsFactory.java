package io.minecraftapps.carmods;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ModsFactory {

    public static List<Mod> getMods(Context context) {

        List<Mod> mods = new ArrayList<>();

        mods.add(new Mod(
                context.getString(R.string.audir8_name),
                context.getString(R.string.audir8_descr),
                context.getString(R.string.audir8_size),
                new int[] { R.drawable.audir8 },
                R.raw.audi_r8,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.camaro_name),
                context.getString(R.string.camaro_descr),
                context.getString(R.string.camaro_size),
                new int[] { R.drawable.camaro_white, R.drawable.camaro_yellow },
                R.raw.chevy_camaro,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.silverado_name),
                context.getString(R.string.silverado_descr),
                context.getString(R.string.silverado_size),
                new int[] { R.drawable.silverado },
                R.raw.chevy_silverado,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.bugatti_name),
                context.getString(R.string.bugatti_descr),
                context.getString(R.string.bugatti_size),
                new int[] { R.drawable.bugatti },
                R.raw.bugatti_veyron,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.cooper_name),
                context.getString(R.string.cooper_descr),
                context.getString(R.string.cooper_size),
                new int[] { R.drawable.cooper },
                R.raw.mini_cooper,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.lamborghini_name),
                context.getString(R.string.lamborghini_descr),
                context.getString(R.string.lamborghini_size),
                new int[] { R.drawable.lambo },
                R.raw.lamborghini_sesto_elemento,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.jetta_name),
                context.getString(R.string.jetta_descr),
                context.getString(R.string.jetta_size),
                new int[] { R.drawable.jetta },
                R.raw.vw_jetta,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.mustang_name),
                context.getString(R.string.mustang_descr),
                context.getString(R.string.mustang_size),
                new int[] { R.drawable.mustang },
                R.raw.ford_mustang_gt,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.f150_name),
                context.getString(R.string.f150_descr),
                context.getString(R.string.f150_size),
                new int[] { R.drawable.f150 },
                R.raw.ford150,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.kart_name),
                context.getString(R.string.kart_descr),
                context.getString(R.string.kart_size),
                new int[] { R.drawable.kart },
                R.raw.kart,
                "mcaddon"
        ));
        mods.add(new Mod(
                context.getString(R.string.dodge_name),
                context.getString(R.string.dodge_descr),
                context.getString(R.string.dodge_size),
                new int[] { R.drawable.dodge },
                R.raw.ram_1500,
                "mcaddon"
        ));

        return mods;

    }

}
