from ProdukMakanan import ProdukMakanan # Mengimpor class ProdukMakanan

class JajananTradisional(ProdukMakanan): #membuat class JajananTradisional yang mewarisi class ProdukMakanan

    # Constructor untuk membuat object JajananTradisional
    #untuk penggunaan (__) atau double underscore untuk membuat attribut tersebut menjadi private 
    def __init__(self, id_produk: str, nama_produk: str, harga: int, bahan: str, rasa: str, lama_ketahanan: int, asal_daerah: str, cara_penyajian: str, jenis_jajanan: str):
        super().__init__(id_produk, nama_produk, harga, bahan, rasa, lama_ketahanan) #memanggil constructor ProdukMakanan
        self.__asal_daerah = asal_daerah #mengisi atribut asal_daerah
        self.__cara_penyajian = cara_penyajian #mengisi atribut cara_penyajian
        self.__jenis_jajanan = jenis_jajanan #mengisi atribut jenis_jajanan

    #etter untuk mengubah asal daerah
    def set_asal_daerah(self, asal_daerah: str):
        self.__asal_daerah = asal_daerah #mengubah nilai atribut asal_daerah

    # Getter untuk mengambil asal daerah
    def get_asal_daerah(self) -> str:
        return self.__asal_daerah #mengembalikan nilai atribut asal_daerah

    #etter untuk mengubah cara penyajian
    def set_cara_penyajian(self, cara_penyajian: str):
        self.__cara_penyajian = cara_penyajian # Mengubah nilai atribut cara_penyajian

    # Getter untuk mengambil cara penyajian
    def get_cara_penyajian(self) -> str:
        return self.__cara_penyajian #mengembalikan nilai atribut cara_penyajian

    #etter untuk mengubah jenis jajanan
    def set_jenis_jajanan(self, jenis_jajanan: str):
        self.__jenis_jajanan = jenis_jajanan # Mengubah nilai atribut jenis_jajanan

    # Getter untuk mengambil jenis jajanan
    def get_jenis_jajanan(self) -> str:
        return self.__jenis_jajanan #mengembalikan nilai atribut jenis_jajanan

    #method untuk menampilkan data jajanan tradisional
    def tampil(self):
        super().tampil() #menampilkan data dari parent class ProdukMakanan
        print(f"Asal Daerah Jajanan    : {self.__asal_daerah}") #menampilkan asal daerah jajanan
        print(f"Cara Penyajian Jajanan : {self.__cara_penyajian}") #menampilkan cara penyajian jajanan
        print(f"Jenis Jajanan          : {self.__jenis_jajanan}") #menampilkan jenis jajanan