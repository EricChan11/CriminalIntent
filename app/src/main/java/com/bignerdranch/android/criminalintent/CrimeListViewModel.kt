package com.bignerdranch.android.criminalintent
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.criminalintent.CrimeRepository

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimes = crimeRepository.getCrimes()
}
