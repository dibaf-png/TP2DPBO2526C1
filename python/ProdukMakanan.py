from Produk import Produk # Mengimpor class Produk

class ProdukMakanan(Produk): # Membuat class ProdukMakanan yang mewarisi class Produk
    #Constructor untuk membuat object ProdukMakanan
    #untuk penggunaan (__) atau double underscore untuk membuat attribut tersebut menjadi private 
    def __init__(self, id_produk: str, nama_produk: str, harga: int, bahan: str, rasa: str, lama_ketahanan: int):
        super().__init__(id_produk, nama_produk, harga) #memanggil constructor parent class Produk
        self.__bahan = bahan #mngisi atribut bahan
        self.__rasa = rasa #mngisi atribut rasa
        self.__lama_ketahanan = lama_ketahanan #mngisi atribut lama_ketahanan

    # setter untuk mengubah bahan
    def set_bahan(self, bahan):
        self.__bahan = bahan # Mengubah nilai atribut bahan

    #getter untuk mengambil bahan
    def get_bahan(self):
        return self.__bahan #Mengembalikan nilai atribut bahan

    #setter untuk mengubah rasa
    def set_rasa(self, rasa):
        self.__rasa = rasa #mngubah nilai atribut rasa

    #getter untuk mengambil rasa
    def get_rasa(self):
        return self.__rasa #mengembalikan nilai atribut rasa

    #setter untuk mengubah lama ketahanan
    def set_lama_ketahanan(self, lama_ketahanan):
        self.__lama_ketahanan = lama_ketahanan #megubah nilai atribut lama_ketahanan

    #getter untuk mengambil lama ketahanan
    def get_lama_ketahanan(self):
        return self.__lama_ketahanan #Mengembalikan nilai atribut lama_ketahanan

    #gethod untuk menampilkan data produk makanan
    def tampil(self):
        super().tampil() # Menampilkan data dasar dari parent class Produk
        print(f"Bahan Produk Makanan  : {self.__bahan}") # Menampilkan bahan produk makanan
        print(f"Rasa Produk Makanan   : {self.__rasa}") # Menampilkan rasa produk makanan
        print(f"Lama Ketahanan        : {self.__lama_ketahanan}") # Menampilkan lama ketahanan produk makanan