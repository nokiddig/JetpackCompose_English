package com.example.english_app.domain.usecase
import com.example.english_app.domain.repository.AccountRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val accountRepositoryImpl: AccountRepository) {
    suspend fun execute(username: String, password: String): Boolean {
        return accountRepositoryImpl.login(username, password)
    }

}