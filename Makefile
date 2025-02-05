commit:
	@git add .
	@echo "Masukkan commit message:"
	@read commit_message; \
	git commit -m "$$commit_message"
	@echo "commit berhasil"


fork:
	@chmod +x ./shell/fork.sh
	@shell/fork.sh
	@echo "success"