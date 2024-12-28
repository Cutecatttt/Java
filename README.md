# Cách sử dụng github:
## Khởi tạo Git
git init

## Kết nối với repository trên GitHub
git remote add origin https://github.com/<tên-người-dùng>/<tên-repository>.git

## Tạo file .gitignore
touch .gitignore

## Thêm nội dung vào .gitignore và thêm file vào Git
git add .gitignore<br>
git commit -m "Thêm .gitignore"

## Thêm file dự án vào Git và commit
git add .<br>
git commit -m "Khởi tạo dự án Java"

## Tạo nhánh main
git branch -M main

## Đẩy dự án lên GitHub
git push -u origin main
