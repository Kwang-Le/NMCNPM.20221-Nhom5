# Phần mềm quản lý thông tin phòng tránh COVID-19
# Giới thiệu
Với tình hình diễn biến phức tạp của dịch COVID-19, cán bộ y tế trong tổ dân phố cần ghi nhận thông tin các nhân khẩu có liên quan đến vùng dịch: thông tin khai báo dịch tễ, trạng thái sức khỏe bất thường của người dân trong tổ khai báo. Nếu có cá nhân hoặc hộ gia đình phải cách ly tập trung hoặc cách ly tại nhà thì cũng cần ghi nhận các thông tin này (thời gian bắt đầu cách ly, mức độ cách ly F0,1,2,3…, đã test COVID-19 chưa, hình thức test, thời điểm test, kết quả các lần test,…). Hàng tuần cán bộ y tế cũng cần thống kê thông tin nhân khẩu liên quan đến dịch COVID-19.

# Danh sách thành viên
- Nguyễn Hàn My - 20205215
- Hoàng Hải Nam - 20205216
- Lê Thanh Quang - 20205218
- Dương Nhật Thành - 20205233

# Tài liệu
- [Báo cáo bài tập lớn](https://drive.google.com/file/d/1M5Pjyy23woUubjDuC1EbjbJvG0Trdi9b/view?usp=share_link)
- [Slide báo cáo](https://docs.google.com/presentation/d/1lsMfM0uV95WRiQZvff8CmErXaT56-kcOVI1kctAj6ys/edit?usp=sharing)

# Hướng dẫn
## Set up môi trường
Cài đặt:
- IDE NetBeans
- MySQL Workbench
- MySQL Server
- JCalendar

## Set up cơ sở dữ liệu
- Mở MySQL Workbench
- Tạo schema với tên là quanlycovid19
- Vào File -> Open SQL Script
- Chọn file "quanlycovidsql.sql"
- Execute file trên

# Quy trình làm việc
1. Fork project
2. Tạo branch feature cần thiết
```
git checkout -b feature/YourFeature
```
3. Commit thay đổi
```
git commit -m "updates to your feature"
```
4. Push lên branch
```
git push origin feature/YourFeature
```
5. Tạo pull request

# Lưu ý
- Vào folder model file DBConnect
- Thay username và password bằng username và password mà bạn dùng cho cơ sở dữ liệu trên máy bạn
