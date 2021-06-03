package ru.mirea.kachalov.mireaproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class StoryDialog extends AppCompatDialogFragment {
    private EditText editStory;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_story, null);
        editStory = view.findViewById(R.id.editStory);

        builder.setView(view)
                .setTitle("Создание истории ")
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Отмена", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Сохранение", Toast.LENGTH_SHORT).show();
                        AppDatabase db = App.getInstance().getDatabase();
                        StoryDao storyDao = db.storyDao();
                        Story story = new Story();
                        story.text = editStory.getText().toString();
                        storyDao.insert(story);
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
