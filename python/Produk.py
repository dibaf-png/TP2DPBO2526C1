class Produk: #membuat class bernama Produk
    #untuk penggunaan (__) atau double underscore untuk membuat attribut tersebut menjadi private 
    def __init__(self, id_produk:str, nama_produk: str, harga : int): #Constructor untuk menginisialisasi atribut pada object Produk
        self.__id_produk = id_produk #menyimpan atribut id produk
        self.__nama_produk = nama_produk #menyimpan atribut nama produk
        self.__harga = harga #menyimpan atribut harga

    #setter untuk mengubah ID produk
    def set_id(self, id_produk):
        self.__id_produk = id_produk #mengubah nilai id_produk

    #getter untuk mengambil ID produk
    def get_id(self):
        return self.__id_produk #mengembalikan nilai id_produk

    #setter untuk mengubah nama produk
    def set_nama(self, nama_produk):
        self.__nama_produk = nama_produk #mengubah nilai nama_produk

    #getter untuk mengambil nama produk
    def get_nama(self):
        return self.__nama_produk #mengembalikan nilai nama_produk

    #setter untuk mengubah harga produk
    def set_harga(self, harga):
        self.__harga = harga #mengubah nilai harga

    #getter untuk mengambil harga produk
    def get_harga(self):
        return self.__harga #mengembalikan nilai harga

    #method untuk menampilkan data produk ke layar
    def tampil(self):
        print(f"Id Produk      : ", self.__id_produk) #untuk mnampilkan id produk
        print(f"Nama Produk    : ", self.__nama_produk) #menampilkan nama produk
        print(f"Harga Produk   : ",self.__harga) #untuk menampilkan harga produk