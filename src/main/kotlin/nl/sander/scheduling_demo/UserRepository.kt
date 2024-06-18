package nl.sander.scheduling_demo

import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    suspend fun getUserCoroutine(id: String): User? {
        return User(name = "User $id", id = id)
    }

    fun getUser(id: String): User? = runBlocking {
        getUserCoroutine(id)
    }
}

data class User(val name: String, val id: String)