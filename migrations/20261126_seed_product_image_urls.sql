BEGIN;

UPDATE public.productos
SET image_url = 'https://oxvdnbdayliurbkhzddv.supabase.co/storage/v1/object/public/productos/1.png'
WHERE id_producto = 1 AND nombre = 'Guayaba';

UPDATE public.productos
SET image_url = 'https://oxvdnbdayliurbkhzddv.supabase.co/storage/v1/object/public/productos/2.jpg'
WHERE id_producto = 2 AND nombre = 'Mango';

UPDATE public.productos
SET image_url = 'https://oxvdnbdayliurbkhzddv.supabase.co/storage/v1/object/public/productos/3.jpg'
WHERE id_producto = 3 AND nombre = 'Manzana';

UPDATE public.productos
SET image_url = 'https://oxvdnbdayliurbkhzddv.supabase.co/storage/v1/object/public/productos/4.jpg'
WHERE id_producto = 4 AND nombre = 'Aguacate';

UPDATE public.productos
SET image_url = 'https://oxvdnbdayliurbkhzddv.supabase.co/storage/v1/object/public/productos/5.jpg'
WHERE id_producto = 5 AND nombre = 'Lechuga';

COMMIT;
