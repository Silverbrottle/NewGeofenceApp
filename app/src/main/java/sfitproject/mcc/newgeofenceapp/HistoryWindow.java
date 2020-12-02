package sfitproject.mcc.newgeofenceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryWindow extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_window);
        firebaseFirestore=firebaseFirestore.getInstance();
        mFirestoreList=findViewById(R.id.firestore_list);

        //Query
        Query query=firebaseFirestore.collection("LocData1");

        FirestoreRecyclerOptions<LocModel> options=new FirestoreRecyclerOptions.Builder<LocModel>()
                .setQuery(query, LocModel.class)
                .build();

        adapter=new FirestoreRecyclerAdapter<LocModel, LocViewHolder>(options) {
            @NonNull
            @Override
            public LocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new LocViewHolder(view);
            }
            @Override
            protected void onBindViewHolder(@NonNull LocViewHolder holder, int position, @NonNull LocModel model) {
                holder.Coordinates.setText("Latitude: " + model.getLatitude() + " Longitude:" + model.getLongitude());
                holder.Radius.setText(model.getRadius()+" ");
                holder.TD.setText(model.getTime()+" ");
            }

        };
        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);
    }

    private class LocViewHolder extends RecyclerView.ViewHolder{
        private TextView Coordinates;
        private TextView Radius;
        private TextView TD;
        public LocViewHolder(@NonNull View itemView){
            super(itemView);
            Coordinates = itemView.findViewById(R.id.Coordinates);
            Radius = itemView.findViewById(R.id.Radius);
            TD=itemView.findViewById(R.id.TD);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}