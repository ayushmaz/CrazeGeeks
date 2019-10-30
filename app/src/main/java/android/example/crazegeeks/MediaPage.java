package android.example.crazegeeks;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaPage extends Fragment {

    ArrayList<Media> mediaArrayList;
    private RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore db;
    Map<String, Object> data;
    private String heading;
    private String content;
    public MediaPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.media_list, container, false);

        mediaArrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
//        mediaArrayList.add(new Media("ABC" , "XYZ"));
//        mediaArrayList.add(new Media("ABC" , "XYZ"));
//        mediaArrayList.add(new Media("ABC" , "XYZ"));
        db.collection("media")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                data = document.getData();
                                Log.d("data", data.toString());


                                try {
                                    heading = data.get("heading").toString();
                                }catch (Exception e){
                                    heading = " ";
                                }
                                try {
                                    content = data.get("content").toString();
                                }catch (Exception e){
                                    content = " ";
                                }
                                //heading = data.get("heading").toString();
                                //content = data.get("content").toString();
                                mediaArrayList.add(new Media(heading,content));

                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }

                        MediaAdapter mediaAdapter = new MediaAdapter(mediaArrayList);
                        layoutManager = new LinearLayoutManager(getActivity());
                        RecyclerView recyclerView= rootView.findViewById(R.id.my_recycler_view);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(mediaAdapter);
                    }
                });


        return rootView;
    }

}
