package com.daykm.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.daykm.demo.databinding.ItemBinding;
import com.daykm.recyclerpager.RecyclerPager;

public class MainActivity extends AppCompatActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		RecyclerPager recyclerPager = new RecyclerPager(this);

		for(int i = 0; i < 20; i++) {
			recyclerPager.add(new Adapter());
		}
		viewPager.setAdapter(recyclerPager);

	}

	static class Adapter extends RecyclerView.Adapter<Holder> {

		@Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
			return new Holder(parent);
		}

		@Override public void onBindViewHolder(Holder holder, int position) {

		}

		@Override public int getItemCount() {
			return 300;
		}
	}

	static class Holder extends RecyclerView.ViewHolder {

		final ItemBinding binding;

		public Holder(ViewGroup parent) {
			super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
			binding = ItemBinding.bind(itemView);
		}
	}
}
