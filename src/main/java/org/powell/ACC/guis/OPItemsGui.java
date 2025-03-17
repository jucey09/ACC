package org.powell.ACC.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.powell.ACC.ACC;

import java.util.List;

public class OPItemsGui {
    private ACC main;
    private ItemStack opsword = new ItemStack(Material.WOODEN_SWORD);
    private ItemStack oppic  = new ItemStack(Material.DIAMOND_PICKAXE);
    private ItemStack opstick = new ItemStack(Material.STICK);
    private ItemStack opaxe = new ItemStack(Material.WOODEN_AXE);
    private ItemStack ophelmat = new ItemStack(Material.CHAINMAIL_HELMET);
    private ItemStack opChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    private ItemStack opLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    private ItemStack opboots = new ItemStack(Material.CHAINMAIL_BOOTS);

    String title = ChatColor.DARK_AQUA + "ACC: OP Items";
    Inventory inv = Bukkit.createInventory(null, 36, title);

    public OPItemsGui(ACC main) {
        this.main = main;

        //OP SWORD
        ItemMeta opswordmeta = opsword.getItemMeta();
        opswordmeta.setDisplayName(ChatColor.YELLOW + "OP Sword");
        opswordmeta.addEnchant(Enchantment.SHARPNESS, 100, true);
        opswordmeta.setUnbreakable(true);
        opsword.setItemMeta(opswordmeta);

        //OP PIC
        ItemMeta oppicMeta = oppic.getItemMeta();
        oppicMeta.setDisplayName(ChatColor.GOLD + "OP Pickaxe");
        oppicMeta.addEnchant(Enchantment.EFFICIENCY, 50, true);
        oppicMeta.addEnchant(Enchantment.FORTUNE, 50, true);
        oppicMeta.setUnbreakable(true);
        oppic.setItemMeta(oppicMeta);

        //OP STICK
        ItemMeta opstickMeta = opstick.getItemMeta();
        opstickMeta.setDisplayName(ChatColor.RED + "OP Stick");
        opstickMeta.addEnchant(Enchantment.KNOCKBACK, 255, true);
        opstick.setItemMeta(opstickMeta);

        //OP AXE
        ItemMeta opaxeMeta = opaxe.getItemMeta();
        opaxeMeta.setDisplayName(ChatColor.BLUE + "OP Axe");
        opaxeMeta.addEnchant(Enchantment.SHARPNESS, 20,true);
        opaxeMeta.addEnchant(Enchantment.EFFICIENCY, 50, true);
        opaxeMeta.addEnchant(Enchantment.FORTUNE, 50, true);
        opaxeMeta.setUnbreakable(true);
        opaxe.setItemMeta(opaxeMeta);

        //OP HELMET
        ItemMeta ophelmatMeta = ophelmat.getItemMeta();
        ophelmatMeta.setDisplayName(ChatColor.AQUA + "OP Helmet");
        ophelmatMeta.addEnchant(Enchantment.PROTECTION, 100, true);
        ophelmatMeta.setUnbreakable(true);
        ophelmat.setItemMeta(ophelmatMeta);

        //OP CHESTPLATE
        ItemMeta opChestplateMeta = opChestplate.getItemMeta();
        opChestplateMeta.setDisplayName(ChatColor.BLUE + "OP Chestplate");
        opChestplateMeta.addEnchant(Enchantment.PROTECTION, 100, true);
        opChestplateMeta.setUnbreakable(true);
        opChestplate.setItemMeta(opChestplateMeta);

        //OP LEGGINGS
        ItemMeta opLeggingsMeta = opLeggings.getItemMeta();
        opLeggingsMeta.setDisplayName(ChatColor.DARK_GRAY + "OP Leggings");
        opLeggingsMeta.addEnchant(Enchantment.PROTECTION, 100, true);
        opLeggingsMeta.setUnbreakable(true);
        opLeggings.setItemMeta(opLeggingsMeta);

        //OP BOOTS
        ItemMeta opbootsMeta = opboots.getItemMeta();
        opbootsMeta.setDisplayName(ChatColor.DARK_PURPLE + "OP Boots");
        opbootsMeta.addEnchant(Enchantment.PROTECTION, 100, true);
        opbootsMeta.setUnbreakable(true);
        opboots.setItemMeta(opbootsMeta);

    }

    public void openGui(Player player) {
        //CLOSE
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        inv.setItem(10, opsword);

        inv.setItem(12, oppic);

        inv.setItem(14, opaxe);

        inv.setItem(16, opstick);

        inv.setItem(19, ophelmat);

        inv.setItem(21, opChestplate);

        inv.setItem(23, opLeggings);

        inv.setItem(25, opboots);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.DARK_GRAY + "_");
        fmeta.setLore(List.of(" "));
        frame.setItemMeta(fmeta);

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 20, 22, 24, 26, 28, 29, 30, 31, 32, 33, 34, 35}) {
            inv.setItem(i, frame);
        }

        ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Main Menu");
        back.setItemMeta(backMeta);

        inv.setItem(27, back);

        player.openInventory(inv);
    }
    public String getTitle() { return title; }
    public ItemStack getOPSword() { return opsword; }
    public ItemStack getOPPic() { return oppic; }
    public ItemStack getOPStick() { return opstick; }
    public ItemStack getOPAxe() { return opaxe; }
    public ItemStack getOPHelmet() { return ophelmat; }
    public ItemStack getOPChestplate() { return opChestplate; }
    public ItemStack getOPLeggings() { return opLeggings; }
    public ItemStack getOPBoots() { return opboots; }
}
