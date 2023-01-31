/*
 * Copyright (c) 2019. Dylan Cai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dlh.movieutils.ui.page.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.dlh.movieutils.R;
import com.dylanc.loadingstateview.LoadingStateView;
import com.dylanc.loadingstateview.ViewType;

/**
 * @author Dylan Cai
 */
public class EmptyViewDelegate extends LoadingStateView.ViewDelegate {

  public EmptyViewDelegate() {
    super(ViewType.EMPTY);
  }

  @NonNull
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
    return inflater.inflate(R.layout.layout_empty, parent, false);
  }
}
