package test_screen.testing_screen

import androidx.fragment.app.viewModels
import com.example.common_api.base.BaseFragment
import com.example.test_category.databinding.FragmentTestingBinding

class TestingFragment :
    BaseFragment<FragmentTestingBinding, TestingViewModel>(FragmentTestingBinding::inflate) {
    override val viewModel: TestingViewModel by viewModels()


}