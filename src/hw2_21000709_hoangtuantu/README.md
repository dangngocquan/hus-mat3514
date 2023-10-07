# Home work 2: Simple Sort
> Lưu ý trước khi chạy chương trình, chương trình ở trong package có import các package khác nhau trong bài. nên tải và giải nén tất cả package trong 1 file tránh trường hợp bị lỗi "Ngớ ngẩn" trong quá trình chạy thử chương trình. Chú ý đọc package mà lớp sử dụng để hiểu được luồng chương trình
> 
> Đối với các bài toán được yêu cầu sắp xếp đã được giảm phần hiển thị bằng cách chỉ in ra kết quả cuối cùng khi tất cả 6 cách sắp xếp đều trả về một kết quả. Chính vì thế nếu đúng tất cả các thuật toán sẽ đúng và ngược lại nếu mảng trả về sai thì sai đồng bộ và ở tất cả các vị trí đều phải sai giống nhau (Điều này gần như bất khả thi)
#### Bài 1
* Bài này sử dụng strategy pattern để tránh việc lặp lại test về các đoạn code
* Trong bài này có 2 lớp để chạy theo 2 mục đích khác nhau:
  * Lớp `Main` thực hiện test và kiểm tra xem các thuật toán sắp xếp khi chạy độc lập có trả về kết quả đúng không. Lớp này kiểm tra bằng cách kiểm tra kết quả của các thuật toán có giống nhau không? Nếu các thuật toán sau khi sắp xếp đều trả về cùng một kết quả sẽ in ra màn hình chuỗi đã được sắp xếp
  * Lớp `Statistics` thực hiện công việc thống kê và so sánh, lấy dữ liệu về thời gian trong các thuật toán sắp xếp và in ra với 20 lần chạy và chia trung bình. 

* Các thuật toán được viết trong các lớp riêng biệt và được implement từ giao diện `Sort`
* Có các tham số cho phép người dùng truyền vào để thực hiện sắp xếp tăng dần hoặc thực hiện in ra từng bước. Tuy nhiên với 2 thuật toán dùng giải thuật đệ quy Em/ mình chưa biết cách để chạy in ra kết quả theo từng bước và in ra tổng số bước lặp như nào nên tính năng này không khả thi.

#### Bài 2
Về cơ bản bài này không khác quá nhiều so với bài 1 tuy nhiên toàn bộ được thay Generic và có thể sử dụng được mọi kiểu dữ liệu. Ở trong phần ví dụ có sử dụng 2 kiểu dữ liệu để làm ví dụ là double và String với độ dài đều bằng 100.

#### Bài 4
> Có thể sử dụng class ở trong package `Hw2_21000709_HoangTuanTu.exercise01` cho các bài 41-51. Đề yêu cầu chỉ cần làm 3 bài tuy nhiên để luyện tập nên em làm để rèn luyện.

> Để tránh việc viết đi viết lại một thuật toán sắp xếp (Mà đa phần sẽ copy paste từ bài trước sang) thì ở bài này sẽ import trực tiếp từ package chứa bài tập số 1. 

> Các mảng đã được chuyển thành tự động khởi tạo để dễ dàng cho các bạn và cô khi xem và chạy thử chương trình.

#### Bài 5
Bài 5 đã được tích hợp sẵn trong package `Hw2_21000709_HoangTuanTu.exercise01` khi chỉ cần truyền thêm tham số false thì sẽ sắp xếp ngược lại (Test chi tiết có thể thử ở trong package `ercise01`)

#### Bài 6
Bài 6 thực hiện sắp xếp sau đấy trả về phần thử tại index = k - 1

#### Bài 8
Bài 8 sử dụng selection sort, chọn các số nhỏ nhất cho các vị trí có số

#### Bài 9
Với bài này thì em/mình chưa có thời gian để hoàn thiện, tuy nhiên bài này có thể giải quyết theo hướng là đổi chỗ tất cả các phần tử có giá trị lớn hơn sang bên trái số ban đầu và số nhỏ hơn sang bên phải. Riêng với số bằng thì sẽ được giữ nguyên vị trí. khi này thì vị trí mới của số chính là đáp án cần tìm. Cách giải quyết này sẽ nhanh hơn việc chúng ta sắp xếp cả mảng sau đó tìm phần tử khi chúng ta không cần quan tâm đến việc phía trước và phía sau có theo thứ tự hay không 