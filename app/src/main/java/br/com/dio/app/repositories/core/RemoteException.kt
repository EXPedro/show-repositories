package br.com.dio.app.repositories.core

//Class to deal w/'generic' error
class RemoteException(override val message: String) : Throwable()