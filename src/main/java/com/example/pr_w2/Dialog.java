package com.example.pr_w2;
package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {
    private String[] multiChoiceItems;
    private AlertDialog alertDialog;
    public Dialog() {
    }

    public Dialog(String[] multiChoiceItems) {
        this.multiChoiceItems = multiChoiceItems;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final boolean[] checkedItems = new boolean[multiChoiceItems.length]; // to keep track of checked items in dialog

        builder.setTitle("Select Items")
                .setMultiChoiceItems(multiChoiceItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // Handle multi-choice item clicks
                        String itemName = multiChoiceItems[which];
                        String action = isChecked ? "checked" : "unchecked";
                        String toastMessage = itemName + " was " + action;

                        // Show a Toast message
                        Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getContext(), "You clicked Close", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); // Dismiss the dialog when Cancel is clicked
            }
        });

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                // Access the "OK" button using AlertDialog.BUTTON_POSITIVE
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        alertDialog = builder.create();



        return alertDialog;
    }
}