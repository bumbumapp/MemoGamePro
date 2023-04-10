package org.bumbumapps.privacyfriendlymemory.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.bumbumapps.privacyfriendlymemory.common.Preference;
import org.bumbumapps.privacyfriendlymemory.ui.navigation.DeckChoiceActivity;
import org.bumbumapps.privacyfriendlymemory.ui.navigation.StatisticsActivity;

/**
 * Created by Hannes on 18.05.2016.
 */
public abstract class AppCompatDrawerActivity extends AppCompatActivity {
    Preference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // the inherited activity have to call the setup method after the specific content view is set
        //setupNavigationView();
    }

    protected void setupNavigationView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preference=new Preference(this);
        findViewById(R.id.main_menu2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Context wrapper = new ContextThemeWrapper(getBaseContext(), R.style.popupMenuStyle);
                PopupMenu popupMenu=new PopupMenu(wrapper, view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_drawer,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
//
                        onNavigationItemSelected(menuItem);
                        return true;
                    }
                });
                popupMenu.setForceShowIcon(true);
                popupMenu.show();
            }
        });
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        switch (id) {
            case R.id.menu_highscore:
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.highscore_dialog, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(this,R.style.HighScore);
                alert.setView(alertLayout);
                alert.setCancelable(true);
                final TextView highscore=alertLayout.findViewById(R.id.highscore);
                highscore.setText(getString(R.string.win_highscore)+"  "+preference.getIntegerHigh("highscore"));
                final TextView time=alertLayout.findViewById(R.id.time);
                time.setText(getString(R.string.win_time)+"  "+preference.getIntegerHigh("highscoreTime"));
                final TextView tries=alertLayout.findViewById(R.id.tries);
                tries.setText(getString(R.string.win_tries)+"  "+preference.getIntegerHigh("highscoreTries"));

                Button okay=alertLayout.findViewById(R.id.okay);

                final AlertDialog dialog = alert.create();
                dialog.show();
                Button resetAll=alertLayout.findViewById(R.id.resetALL);
                resetAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        preference.putIntegerHigh("highscore", 0);
                        preference.putIntegerHigh("highscoreTries", 0);
                        preference.putIntegerHigh("highscoreTime", 0);
                        time.setText(getString(R.string.win_time)+"  "+0);
                        tries.setText(getString(R.string.win_tries)+"  "+0);
                        highscore.setText(getString(R.string.win_highscore)+"  "+0);

                    }
                });
                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.menu_statistics:
                intent = new Intent(this, StatisticsActivity.class);
                break;
            case R.id.about:
                showAboutDialog();
                break;
            case R.id.menu_settings:
                intent = new Intent(this, DeckChoiceActivity.class);
                intent.putExtra(DeckChoiceActivity.EXTRA_SHOW_FRAGMENT, DeckChoiceActivity.HelpFragment.class.getName());
                intent.putExtra(DeckChoiceActivity.EXTRA_NO_HEADERS, true);
                break;


        }

        if (intent != null){
            startActivity(intent);
        }

        return true;
    }

    private void showAboutDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_about);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        int margin = 20;
        InsetDrawable inset = new InsetDrawable(back, margin);
        dialog.getWindow().setBackgroundDrawable(inset);
        ((ImageButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null)
                    dialog.dismiss();
            }
        });

        ((Button) dialog.findViewById(R.id.bt_licence)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://github.com/SecUSo/privacy-friendly-memo-game/blob/master/LICENSE.md";
                Intent urlIntent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(urlIntent);
            }
        });
        ((Button) dialog.findViewById(R.id.app_source_code)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://github.com/bumbumapp/MemoGamePro";
                Intent urlIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlIntent);
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    @Override
    public void onBackPressed()
    {
            super.onBackPressed();

    }

}
