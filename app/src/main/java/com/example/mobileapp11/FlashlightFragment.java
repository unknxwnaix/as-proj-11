package com.example.mobileapp11;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FlashlightFragment extends Fragment {

    private boolean isFlashOn = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashlight, container, false);
        ImageButton flashlightButton = view.findViewById(R.id.flashlight_button);

        flashlightButton.setOnClickListener(v -> toggleFlashlight());

        return view;
    }

    private void toggleFlashlight() {
        requireContext();
        CameraManager cameraManager = (CameraManager) requireActivity().getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            isFlashOn = !isFlashOn;
            cameraManager.setTorchMode(cameraId, isFlashOn);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
