package io.github.nisanthmp.helloandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

public class WriteFragment extends Fragment {
    byte one = 0b00100000;
    byte two = 0b00010000;
    byte three = 0b00001000;
    byte four = 0b00000100;
    byte five = 0b00000010;
    byte six = 0b00000001;

    int black = 0xFF000000;
    int white = 0xFFFFFFFF;

    byte[] touched = new byte[6];
    List<Byte> inputMessageBytes = new ArrayList<Byte>();

    OutputModule outputModule = new OutputModule();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write, container, false);
    }

    public void onViewCreated(@NonNull View fragmentView, Bundle savedInstanceState) {
        super.onViewCreated(fragmentView, savedInstanceState);

        fragmentView.findViewById(R.id.writer_button_to_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                outputModule.setInputCharByteArray(inputMessageBytes.toArray());
                outputModule.sendMessage();
                try {
                    Thread.sleep(100);
                } catch (Exception error) {
                    Log.d("Exception", error.toString());
                }
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                try {
                    Thread.sleep(100);
                } catch (Exception error) {
                    Log.d("Exception", error.toString());
                }
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                NavHostFragment.findNavController(WriteFragment.this)
                        .navigate(R.id.action_WriteFragment_to_OptionsFragment);
            }
        });

        setDotsClickListeners(fragmentView);
        refreshDisplay(fragmentView);
    }

    private void setDotsClickListeners(final View fragmentView) {
        final Button write_button_1 = fragmentView.findViewById(R.id.write_button_1);
        write_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_1.setBackgroundColor(black);
                touched[0] = one;
            }
        });
        final Button write_button_2 = fragmentView.findViewById(R.id.write_button_2);
        write_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_2.setBackgroundColor(black);
                touched[1] = two;
            }
        });
        final Button write_button_3 = fragmentView.findViewById(R.id.write_button_3);
        write_button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_3.setBackgroundColor(black);
                touched[2] = three;
            }
        });
        final Button write_button_4 = fragmentView.findViewById(R.id.write_button_4);
        write_button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_4.setBackgroundColor(black);
                touched[3] = four;
            }
        });
        final Button write_button_5 = fragmentView.findViewById(R.id.write_button_5);
        write_button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_5.setBackgroundColor(black);
                touched[4] = five;
            }
        });
        final Button write_button_6 = fragmentView.findViewById(R.id.write_button_6);
        write_button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                write_button_6.setBackgroundColor(black);
                touched[5] = six;
            }
        });

        write_button_6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                collectInputChar();
                refreshDisplay(fragmentView);
                return true;
            }
        });

        return;
    }

    private void refreshDisplay(View view) {
        for (int i = 0; i < 6; i++) {
            touched[i] = 0b00000000;
        }

        Button write_button_1 = view.findViewById(R.id.write_button_1);
        Button write_button_2 = view.findViewById(R.id.write_button_2);
        Button write_button_3 = view.findViewById(R.id.write_button_3);
        Button write_button_4 = view.findViewById(R.id.write_button_4);
        Button write_button_5 = view.findViewById(R.id.write_button_5);
        Button write_button_6 = view.findViewById(R.id.write_button_6);
        write_button_1.setBackgroundColor(white);
        write_button_2.setBackgroundColor(white);
        write_button_3.setBackgroundColor(white);
        write_button_4.setBackgroundColor(white);
        write_button_5.setBackgroundColor(white);
        write_button_6.setBackgroundColor(white);
    }

    private void collectInputChar() {
        byte inputCharByte = 0b00000000;
        for (int i = 0; i < 6; i++) {
            inputCharByte |= touched[i];
        }
        inputMessageBytes.add(inputCharByte);
        Log.d("Input Byte: ", new Byte(inputCharByte).toString());
    }


}
