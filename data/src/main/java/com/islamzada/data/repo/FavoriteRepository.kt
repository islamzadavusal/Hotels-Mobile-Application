package com.islamzada.data.repo

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.islamzada.entities.model.HotelsResponse
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

//interface FavoriteRepositoryInterface {
//    fun getAll(result : (List<HotelUIModel>)->Unit)
//}
//
//class FavoriteRepository @Inject constructor(val database : FirebaseFirestore) : FavoriteRepositoryInterface {
//    override fun getAll(result: (List<HotelUIModel>) -> Unit) {
//        val currentUserUID = FirebaseAuth.getInstance().currentUser?.uid
//        currentUserUID?.let { uid ->
//            database.collection("users").document(uid)
//                .collection("currentUser")
//                .get()
//                .addOnSuccessListener {
//                    val tempList = mutableListOf<HotelUIModel>()
//                    for (document in it) {
//                        val fav = document.toObject(HotelUIModel::class.java)
//                        tempList.add(fav)
//                    }
//                    result(tempList)
//                }
//            .addOnFailureListener {
//                result(emptyList())
//            }
//    }
//    }
//}

//interface FavoriteRepositoryInterface {
//    suspend fun getAll(): Flow<Resource<List<HotelUIModel>>>
//}
//

//class FavoriteRepository @Inject constructor(private val database: FirebaseFirestore) : FavoriteRepositoryInterface {
//    override suspend fun getAll(): Flow<Resource<List<HotelUIModel>>> = callbackFlow {
//        val collection = database.collection("users")
//        val currentUserUID = FirebaseAuth.getInstance().currentUser?.uid
//
//        currentUserUID?.let { uid ->
//                 collection.document(uid)
//                .collection("currentUser")
//                .get()
//                .addOnSuccessListener { querySnapshot ->
//                    val tempList = mutableListOf<HotelUIModel>()
//                    for (document in querySnapshot.documents) {
//                        val fav = document.toObject(HotelUIModel::class.java)
//                        fav?.let {
//                            tempList.add(it) }
//                    }
//
//                    trySend(Resource.Success(tempList))
//                }
//                .addOnFailureListener { exception ->
//                    trySend(Resource.Error(exception))
//                }
//
//            awaitClose {
//
//            }
//        }
//    }
//}
//
//sealed class Resource<out T> {
//    data class Success<out T>(val data: T) : Resource<T>()
//    data class Error(val exception: Exception) : Resource<Nothing>()
//}

//interface FavoriteRepositoryInterface {
//    suspend fun getAll(): Flow<List<HotelsResponse>>
//}
//
//class FavoriteRepository @Inject constructor(private val database: FirebaseFirestore) : FavoriteRepositoryInterface {
//    override suspend fun getAll(): Flow<List<HotelsResponse>> = callbackFlow {
//        val collection = database.collection("users")
//        val currentUserUID = FirebaseAuth.getInstance().currentUser?.uid
//
//        currentUserUID?.let { uid ->
//            collection.document(uid)
//                .collection("currentUser")
//                .get()
//                .addOnSuccessListener { querySnapshot ->
//                    val tempList = mutableListOf<HotelsResponse>()
//                    for (document in querySnapshot.documents) {
//                        val fav = document.toObject(HotelsResponse::class.java)
//                        fav?.let {
//                            tempList.add(it) }
//                    }
//
//                    trySend(tempList).isSuccess
//                }
//                .addOnFailureListener { exception ->
//                    close(exception)
//                }
//
//            awaitClose {
//
//            }
//        }
//    }
//}

//
//interface FavoriteRepositoryInterface {
//    suspend fun getAll(): HotelsResponse?
//}
//
//class FavoriteRepository @Inject constructor(private val database: FirebaseFirestore) : FavoriteRepositoryInterface {
//
//    override suspend fun getAll(): HotelsResponse? {
//        val currentUserUID = FirebaseAuth.getInstance().currentUser?.uid
//        return currentUserUID?.let { uid ->
//            val querySnapshot = database.collection("users")
//                .document(uid)
//                .collection("currentUser")
//                .get()
//                .await()
//
//            for (document in querySnapshot) {
//                val fav = document.toObject(HotelsResponse::class.java)
//                return fav
//            }
//            null
//        }
//    }
//}

